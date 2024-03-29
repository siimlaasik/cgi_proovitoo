package org.example.cgi_proovitoo.service.generator;

import lombok.Getter;
import lombok.Setter;
import org.example.cgi_proovitoo.repository.Movie;
import org.example.cgi_proovitoo.repository.Session;

import java.util.*;

@Getter
@Setter
public class SessionSuggestions {
    private final List<Session> history;
    private final HashMap<String, List<Double>> genreMap = new HashMap<>();
    private final List<Movie> movies;
    private float avgRating;
    private float avgAgeLimit;
    private static final int AMOUNT = 0;
    private static final int TOTAL_RATING = 1;
    private static final int TOTAL_AGE_LIMIT = 2;
    private static final double OVERALL_WEIGHT_THRESHOLD = 0.5;

    public SessionSuggestions(List<Session> history, List<Movie> moviesNotSeen) {
        this.history = history;
        this.movies = moviesNotSeen;
    }
    private void calculateAverages() {
        for (Map.Entry<String, List<Double>> entry : genreMap.entrySet()) {
            String genre = entry.getKey();
            List<Double> stats = entry.getValue();
            double avgRating = stats.get(TOTAL_RATING) / stats.get(AMOUNT);
            double avgAgeLimit = stats.get(TOTAL_AGE_LIMIT) / stats.get(AMOUNT);
            List<Double> newStats = new ArrayList<>();
            newStats.add(stats.get(AMOUNT));
            newStats.add(avgRating);
            newStats.add(avgAgeLimit);
            genreMap.put(genre, newStats);
        }
    }
    private void analyzeHistory() {
        for (Session session : history) {
            String genre = session.getMovie().getGenre();
            double rating = (double) session.getMovie().getRating();
            int ageLimit = session.getMovie().getAgeLimit();

            if (genreMap.containsKey(genre)) {
                double new_amount = genreMap.get(genre).get(AMOUNT) + 1;
                double new_rating = genreMap.get(genre).get(TOTAL_RATING) + rating;
                double new_age = genreMap.get(genre).get(TOTAL_AGE_LIMIT) + ageLimit;

                genreMap.get(genre).set(AMOUNT, new_amount);
                genreMap.get(genre).set(TOTAL_RATING, new_rating);
                genreMap.get(genre).set(TOTAL_AGE_LIMIT, new_age);

            } else {
                List<Double> genreStats = new ArrayList<>();
                genreStats.add(1.0);
                genreStats.add(rating);
                genreStats.add((double) ageLimit);

                genreMap.put(genre, genreStats);
            }
        }
        calculateAverages();
    }

    public List<Movie> suggestMovies() {
        analyzeHistory();
        List<Movie> suggestions = new ArrayList<>();
        Map<Movie, Double> movieWeights = calculateMovieWeights();
        List<Movie> nonGenreMatchSuggestions = filterNonGenreMatchMovies();

        if (movieWeights.isEmpty()) {
            return sortAndReturnNonGenreMatchSuggestions(nonGenreMatchSuggestions);
        }

        return sortAndReturnSuggestions(movieWeights, suggestions);
    }

    private Map<Movie, Double> calculateMovieWeights() {
        Map<Movie, Double> movieWeights = new HashMap<>();
        for (Movie movie : movies) {
            String genre = movie.getGenre();
            if (genreMap.containsKey(genre)) {
                double overallWeight = calculateOverallWeight(movie, genreMap.get(genre));
                if (overallWeight >= OVERALL_WEIGHT_THRESHOLD) {
                    movieWeights.put(movie, overallWeight);
                }
            }
        }
        return movieWeights;
    }

    private double calculateOverallWeight(Movie movie, List<Double> genreStats) {
        double movieRating = movie.getRating();
        int movieAgeLimit = movie.getAgeLimit();
        double avgRating = genreStats.get(TOTAL_RATING) / genreStats.get(AMOUNT);
        double avgAgeLimit = genreStats.get(TOTAL_AGE_LIMIT) / genreStats.get(AMOUNT);
        double genreWatchCount = genreStats.get(AMOUNT);

        double ratingDifference = Math.abs(movieRating - avgRating);
        double ageLimitDifference = Math.abs(movieAgeLimit - avgAgeLimit);
        double ratingWeight = 1 - (ratingDifference / 10);
        double ageLimitWeight = 1 - (ageLimitDifference / 20);
        double genreWatchCountWeight = genreWatchCount / 10;

        return ratingWeight * ageLimitWeight * genreWatchCountWeight;
    }

    private List<Movie> filterNonGenreMatchMovies() {
        List<Movie> nonGenreMatchSuggestions = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getRating() > 8 && !genreMap.containsKey(movie.getGenre())) {
                nonGenreMatchSuggestions.add(movie);
            }
        }
        return nonGenreMatchSuggestions;
    }

    private List<Movie> sortAndReturnNonGenreMatchSuggestions(List<Movie> nonGenreMatchSuggestions) {
        nonGenreMatchSuggestions.sort(Comparator.comparing(Movie::getRating).reversed());
        return nonGenreMatchSuggestions;
    }

    private List<Movie> sortAndReturnSuggestions(Map<Movie, Double> movieWeights, List<Movie> suggestions) {
        List<Map.Entry<Movie, Double>> sortedEntries = new ArrayList<>(movieWeights.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<Movie, Double> entry : sortedEntries) {
            suggestions.add(entry.getKey());
        }
        return suggestions;
    }

}

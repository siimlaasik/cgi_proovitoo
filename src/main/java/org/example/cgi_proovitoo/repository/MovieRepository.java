package org.example.cgi_proovitoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT DISTINCT m FROM Movie m " +
            "WHERE m.movieId NOT IN " +
            "(SELECT s.movie.movieId FROM Session s " +
            "WHERE s.sessionId IN " +
            "(SELECT sg.sessionId FROM SessionGuest sg WHERE sg.profileId = :profileId))")
    List<Movie> findMoviesNotSeenByProfileId(int profileId);

}


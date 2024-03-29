package org.example.cgi_proovitoo.mapper;

import org.example.cgi_proovitoo.controller.dto.MovieDto;
import org.example.cgi_proovitoo.repository.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie movieDtoToMovie(MovieDto movieDto);
    MovieDto movieToMovieDto(Movie movie);
}

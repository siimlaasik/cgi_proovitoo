package org.example.cgi_proovitoo.mapper;

import org.example.cgi_proovitoo.controller.dto.MovieDto;
import org.example.cgi_proovitoo.controller.dto.RoomSizeDto;
import org.example.cgi_proovitoo.controller.dto.SessionDto;
import org.example.cgi_proovitoo.repository.Movie;
import org.example.cgi_proovitoo.repository.Room;
import org.example.cgi_proovitoo.repository.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    Session sessionDtoToSession(SessionDto sessionDto);


    @Mapping(target = "movie", source = "session.movie")
    @Mapping(target = "room", source = "session.room")
    SessionDto sessionToSessionDto(Session session);

    MovieDto mapMovieToDto(Movie movie);

    RoomSizeDto mapRoomToDto(Room room);
}

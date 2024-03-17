package org.example.cgi_proovitoo.mapper;

import org.example.cgi_proovitoo.controller.dto.SessionDto;
import org.example.cgi_proovitoo.repository.Session;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessionMapper {
    Session sessionDtoToSession(SessionDto sessionDto);
    SessionDto sessionToSessionDto(Session session);
}

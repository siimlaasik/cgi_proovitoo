package org.example.cgi_proovitoo.mapper;

import org.example.cgi_proovitoo.controller.dto.SessionDto;
import org.example.cgi_proovitoo.controller.dto.SessionGuestDto;
import org.example.cgi_proovitoo.repository.Session;
import org.example.cgi_proovitoo.repository.SessionGuest;
import org.mapstruct.Mapping;

public interface SessionGuestMapper {
    SessionGuest sessionGuestDtoToSessionGuest(SessionGuestDto sessionGuestDto);


    SessionGuestDto sessionGuestToSessionGuestDto(SessionGuest sessionGuest);
}

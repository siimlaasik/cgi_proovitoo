package org.example.cgi_proovitoo.controller.dto;

import org.example.cgi_proovitoo.repository.Movie;
import org.example.cgi_proovitoo.repository.Room;

import java.time.LocalDateTime;

public record SessionDto(Integer sessionId, LocalDateTime time, Room room, Movie movie, String language) {

}

package org.example.cgi_proovitoo.controller.dto;

import java.sql.Date;

public record SessionDto(Integer session_id, Date time, Integer movie_id, Integer room_id) {
}

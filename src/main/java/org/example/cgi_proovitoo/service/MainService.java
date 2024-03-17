package org.example.cgi_proovitoo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cgi_proovitoo.controller.dto.MovieDto;
import org.example.cgi_proovitoo.controller.dto.SessionDto;
import org.example.cgi_proovitoo.mapper.MovieMapper;
import org.example.cgi_proovitoo.mapper.SessionMapper;
import org.example.cgi_proovitoo.repository.MovieRepository;
import org.example.cgi_proovitoo.repository.Session;
import org.example.cgi_proovitoo.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {
    public final MovieRepository movieRepository;
    public final MovieMapper movieMapper;
    public final SessionRepository sessionRepository;
    public final SessionMapper sessionMapper;

    public MovieDto getMovie(Integer id) {
        var movie = movieRepository.getReferenceById(id);
        return movieMapper.movieToMovieDto(movie);
    }

    public SessionDto getSession(Integer id) {
        var session = sessionRepository.getReferenceById(id);
        return sessionMapper.sessionToSessionDto(session);
    }

    public List<SessionDto> getSessions() {
        List<SessionDto> sessionDtos = new ArrayList<>();
        for (Session session : sessionRepository.findAll()) {
            var sessionDto = sessionMapper.sessionToSessionDto(session);
            sessionDtos.add(sessionDto);
        }
        return sessionDtos;
    }
}

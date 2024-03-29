package org.example.cgi_proovitoo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cgi_proovitoo.controller.dto.MovieDto;
import org.example.cgi_proovitoo.controller.dto.RoomSizeDto;
import org.example.cgi_proovitoo.controller.dto.SessionDto;
import org.example.cgi_proovitoo.controller.dto.SessionGuestDto;
import org.example.cgi_proovitoo.mapper.MovieMapper;
import org.example.cgi_proovitoo.mapper.RoomMapper;
import org.example.cgi_proovitoo.mapper.SessionMapper;
import org.example.cgi_proovitoo.repository.MovieRepository;
import org.example.cgi_proovitoo.repository.Session;
import org.example.cgi_proovitoo.repository.SessionRepository;
import org.example.cgi_proovitoo.repository.*;
import org.example.cgi_proovitoo.service.generator.SeatGenerator;
import org.example.cgi_proovitoo.service.generator.SessionSuggestions;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {
    public final MovieRepository movieRepository;
    public final MovieMapper movieMapper;
    public final SessionRepository sessionRepository;
    public final SessionMapper sessionMapper;
    public final RoomRepository roomRepository;
    public final RoomMapper roomMapper;
    public final SessionGuestRepository sessionGuestRepository;


    public MovieDto getMovie(Integer id) {
        var movie = movieRepository.getReferenceById(id);
        return movieMapper.movieToMovieDto(movie);
    }

    public SessionDto getSession(Integer id) {
        var session = sessionRepository.findBySessionId(id);
        return sessionMapper.sessionToSessionDto(session);
    }



    public List<SessionDto> getSessions() {
        List<SessionDto> sessionDtos = new ArrayList<>();
        for (Session session : sessionRepository.findAllSessionsWithMoviesAndRooms()) {
            var sessionDto = sessionMapper.sessionToSessionDto(session);
            sessionDtos.add(sessionDto);
        }
        return sessionDtos;
    }
    public SessionGuestDto getSessionGuests(Integer id, Integer ticketNr) {
        var room = sessionRepository.getReferenceById(id).getRoom();
        SeatGenerator seatGenerator = new SeatGenerator(room.getRows(), room.getSeatsPerRow());
        return seatGenerator.generateDto(ticketNr);
    }

    public List<SessionDto> getSessionsByMovieGenre(String genre) {
        List<Session> sessions = sessionRepository.findAllByMovieGenre(genre);
        return sessions.stream()
                .map(sessionMapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    public List<SessionDto> getSessionsByMovieAgeLimit(Integer ageLimit) {
        List<Session> sessions = sessionRepository.findAllByMovieAgeLimit(ageLimit);
        return sessions.stream()
                .map(sessionMapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    public List<SessionDto> getSessionsAfter(LocalDateTime time) {
        List<Session> sessions = sessionRepository.findAllByTimeAfter(time);
        return sessions.stream()
                .map(sessionMapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    public List<SessionDto> getSessionsByLanguage(String language) {
        List<Session> sessions = sessionRepository.findAllByLanguage(language);
        return sessions.stream()
                .map(sessionMapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

}

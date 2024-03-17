package org.example.cgi_proovitoo.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cgi_proovitoo.controller.dto.MovieDto;
import org.example.cgi_proovitoo.controller.dto.SessionDto;
import org.example.cgi_proovitoo.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MainController {
    public final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping()
    public String main() {
        return "Hello!";
    }

    @GetMapping("/api/movie/{id}")
    public MovieDto viewMovie(@PathVariable Integer id) {
        return mainService.getMovie(id);
    }

    @GetMapping("/api/session/{id}")
    public SessionDto viewSession(@PathVariable Integer id) {
        return mainService.getSession(id);
    }

    @GetMapping("/api")
    public List<SessionDto> viewSessions() {
        return mainService.getSessions();
    }
}

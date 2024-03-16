package org.example.cgi_proovitoo.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cgi_proovitoo.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

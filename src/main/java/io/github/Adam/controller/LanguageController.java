package io.github.Adam.controller;


import io.github.Adam.DTO.LanguageDTO;
import io.github.Adam.service.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public
class LanguageController {


    private final LanguageService service;

    @Autowired
    LanguageController(LanguageService service) {
        this.service = service;

    }
    @GetMapping("/langs")
    ResponseEntity<List<LanguageDTO>> findAllLang() {
        log.info("Got request");
        return ResponseEntity.ok(service.findAll());
    }

}

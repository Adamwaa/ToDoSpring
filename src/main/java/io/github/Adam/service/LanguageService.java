package io.github.Adam.service;


import io.github.Adam.DTO.LanguageDTO;
import io.github.Adam.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LanguageService {
    private LanguageRepository repository;

    LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }
    public List<LanguageDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(LanguageDTO::new)
                .collect(Collectors.toList());
    }
}

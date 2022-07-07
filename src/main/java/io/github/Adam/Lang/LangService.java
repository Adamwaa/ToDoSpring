package io.github.Adam.Lang;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
class LangService {

    private LangRepository repository;

   LangService(LangRepository repository) {
        this.repository = repository;
    }

    List<LangDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(Collectors.toList());
    }
}

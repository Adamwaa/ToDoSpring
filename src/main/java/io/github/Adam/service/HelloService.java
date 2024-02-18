package io.github.Adam.service;


import io.github.Adam.repository.LanguageRepository;
import io.github.Adam.Lang.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HelloService {
    public static final String FALLBACK_NAME = "world";
    public static final Language FALLBACK_LANG = new Language(1, "Hello", "en");
    private LanguageRepository repository;

    @Autowired
    HelloService(LanguageRepository repository) {
        this.repository = repository;
    }

    public String prepareGreeting(String name, Integer langId) {
        String welcomeMsg = Optional.ofNullable(langId)
                .flatMap(repository::findById)
                .map(Language::getWelcomemsg)
                .orElse(FALLBACK_LANG.getWelcomemsg());

        String nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }



}


package io.github.Adam.Hello;


import io.github.Adam.Lang.Lang;
import io.github.Adam.Lang.LangRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


//Spring service
@Service
public class HelloService {

    public static final String FALLBACK_NAME = "world";
    public static final Lang FALLBACK_LANG = new Lang(1, "Hello", "en");

    private LangRepository repository;

   HelloService(LangRepository repository) {
        this.repository = repository;
    }



    public String prepareGreeting(String name, Integer langId) {
        langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomemsg();
        var code = repository.findById(langId).orElse(FALLBACK_LANG).getCode();
        var  nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}


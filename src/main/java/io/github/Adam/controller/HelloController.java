package io.github.Adam.controller;


import io.github.Adam.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public
class HelloController {

    private HelloService service;
    HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping(value = "/api")
    String welcome(@RequestParam("lang") Integer langId,
                   @RequestParam("name") String name) {
        log.info("Recived paramteres: langId={}, name={}", langId, name);
        return service.prepareGreeting(name, langId);
    }
}

package io.github.Adam.Hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class HelloServlet {

    //connection servlet-service
    HelloServlet(HelloService service) {
        this.service = service;
    }

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private HelloService service;

    @GetMapping("/api")
    String welcome() {
        return welcome(null, null);
    }

    @GetMapping(value = "/api", params = {"lang","name"})
    String welcome(@RequestParam("lang") Integer landId, @RequestParam String name) {
        logger.info("Get parameter");
        return service.prepareGreeting(name,landId);
    }
}

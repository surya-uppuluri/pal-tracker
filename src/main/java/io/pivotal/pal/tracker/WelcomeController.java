package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    public String welcomeMsg;

    public WelcomeController(@Value("${welcome.message}") String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    @GetMapping("/")
    public String sayHello() {
        return welcomeMsg;
    }
}
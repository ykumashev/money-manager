package io.aqsha.api.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello")
    public String firstPage() {
        return "Hello World";
    }

    @GetMapping(path = "/home")
    public String secondPage() {
        return "Home page";
    }
}

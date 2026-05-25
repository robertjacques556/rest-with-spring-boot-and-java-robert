package br.com.robert.controllers;

import br.com.robert.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong cunter = new AtomicLong();
    //http://localhost:8080/greting?name=Leandro
    @RequestMapping("/greeting")
    public Greeting greeting (
            @RequestParam(value ="name", defaultValue = "Word")
            String name){
        return new Greeting(cunter.incrementAndGet(), String.format(template, name));


    }
}

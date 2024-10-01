package org.example.ch06;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {


    private final Greeting greeting;
    private final Droid droid;



//    @Value("${greeting-name: test}")
//    private String name;
//
//    @Value("${greeting-coffee}")
//    private String greetingCoffee;
//
//    @GetMapping("/greeting")
//    public String getGreeting() {
//        return name;
//    }
//
//    @GetMapping("/coffee")
//    public String Coffee() {
//        return greetingCoffee;
//    }

    @GetMapping("/greeting")
    public String greeting() {
        return greeting.getName();
    }

    @GetMapping("/coffee")
    public String coffee() {
        return greeting.getCoffee();
    }

    @GetMapping("/droid")
    public Droid getDroid() {
        return droid;
    }
}

package org.example.ch06;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class GreetingController {

//    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
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
        log.trace("트레이스 로그인입니다.");
        log.info("인포 로그입니다.");
        return greeting.getCoffee();
    }

    @GetMapping("/droid")
    public Droid getDroid() {
        return droid;
    }
}

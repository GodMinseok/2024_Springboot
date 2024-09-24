package org.example.ch05.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/test")
    public String test(Model model){

        Person person = new Person();
        person.setId(1L);
        person.setName("서민석");
        person.setAge(25);
        person.setHobbies(List.of("아스날 쳐 발리는 경기 보기","ㅇㅇ"));

        model.addAttribute("person",person);
        model.addAttribute("welcome","안녕하세요");
        model.addAttribute("today", LocalDateTime.now());

        return "test"; // resources\templates\test.html
    }

    @Getter
    @Setter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}

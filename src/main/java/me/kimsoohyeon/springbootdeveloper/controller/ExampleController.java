package me.kimsoohyeon.springbootdeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model){
        Person examplerPerson = new Person();
        examplerPerson.setId(1L);
        examplerPerson.setName("홍길동");
        examplerPerson.setAge(11);
        examplerPerson.setHobbies(List.of("운동", "독서"));

        model.addAttribute("person", examplerPerson);
        model.addAttribute("today", LocalDate.now());
        
        return "example";
    }

    @Setter
    @Getter
    class Person{
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}

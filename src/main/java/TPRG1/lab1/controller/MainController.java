package TPRG1.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {


    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "main";
    }




}
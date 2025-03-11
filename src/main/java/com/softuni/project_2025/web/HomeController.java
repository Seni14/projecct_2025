package com.softuni.project_2025.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping("/home")
    public String ViemHome(){
    return "home";


    }
}

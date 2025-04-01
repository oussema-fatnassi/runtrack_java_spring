package com.example.Jour2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String viewPage(Model model) {
        model.addAttribute("message", "👋");
        return "view"; 
    }
}

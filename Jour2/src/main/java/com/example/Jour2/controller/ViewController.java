package com.example.Jour2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String viewPage(Model model) {
        model.addAttribute("message", "👋");
        return "view"; 
    }

    @GetMapping("/view2")
    public String viewList(Model model) {
        List<String> items = Arrays.asList("Apples", "Peaches", "Pears", "Oranges", "Bananas");
        model.addAttribute("items", items);
        return "view2";
    }

    @GetMapping("/view3")
    public String showForm(){
        return "view3";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String name, Model model) {
      String welcomeMessage = "Welcome, " + name + "!";
      model.addAttribute("welcomeMessage", welcomeMessage);
      return "welcome";
    }
}

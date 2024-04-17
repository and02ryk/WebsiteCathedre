package com.example.myweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/teachers")
    public String teachers(Model model){
        model.addAttribute("title", "Преподаватели");
        return "teachers";
    }

    @GetMapping("/history")
    public String history(Model model){
        model.addAttribute("title", "История нашей кафедры");
        return "history";
    }

    @GetMapping("/contacts")
    public String about(Model model){
        model.addAttribute("title", "Наши контакты");
        return "contacts";
    }

    @GetMapping("/admin")
    public String account(Model model){
        model.addAttribute("title", "Панель администратора");
        return "admin";
    }
}
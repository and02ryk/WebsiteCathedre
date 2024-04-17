package com.example.myweb.controllers;

import com.example.myweb.model.News;
import com.example.myweb.model.ScientificActivity;
import com.example.myweb.repos.ScientificActivityRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SCController {
    @Autowired
    private ScientificActivityRepos scientificActivityRepos;

    @GetMapping("/article")
    public String articleMain(Model model) {
        Iterable<ScientificActivity> scientificActivity = scientificActivityRepos.findAll();
        model.addAttribute("scientificActivity", scientificActivity);
        return "redirect:/home";
    }

    @PostMapping
    public String articlePostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String theme, @RequestParam String author, @RequestParam String full_text, Model model){
        ScientificActivity sa = new ScientificActivity(title, anons, theme, author, full_text);
        scientificActivityRepos.save(sa);
        return "redirect:/home";
    }
}

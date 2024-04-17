package com.example.myweb.controllers;

import com.example.myweb.model.News;
import com.example.myweb.repos.NewsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsController {
    @Autowired
    private NewsRepos newsRepos;

    @GetMapping("/news")
    public String newsMain(Model model) {
        Iterable<News> news = newsRepos.findAll();
        model.addAttribute("news", news);
        return "/news";
    }

    @GetMapping("/news/add")
    public String newsAdd(Model model) {
        return "/news-add";
    }

    @PostMapping
    public String newsPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        News news = new News(title, anons, full_text);
        newsRepos.save(news);
        return "redirect:/home";
    }
}

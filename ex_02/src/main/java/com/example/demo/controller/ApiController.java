package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Joke;
import com.example.demo.service.JokeService;

@RestController
@RequestMapping("/api/jokes")
public class ApiController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/categories") // http://localhost:8080/api/jokes/categories
    public List<String> getCategories() {
        return jokeService.getCategories();
    }

    @GetMapping("/random") // http://localhost:8080/api/jokes/random?category=career
    public Joke getByCategory(@RequestParam String[] category) {
        return jokeService.getRandomJoke(category);
    }
    // "animal",
    // "career",
    // "celebrity",
    // "dev",
    // "explicit",
    // "fashion",
    // "food",
    // "history",
    // "money",
    // "movie",
    // "music",
    // "political",
    // "religion",
    // "science",
    // "sport",
    // "travel"

    @GetMapping("/randomById") // http://localhost:8080/api/jokes/randomById?query=id
    public Joke getById(@RequestParam String query) {
        return jokeService.getRandomJokeById(query);
    }

    @GetMapping("/randomExclude") // http://localhost:8080/api/jokes/randomExclude?exclude=animal
    public Joke exclude(@RequestParam String[] exclude) {
        return jokeService.getRandomJokeExclude(exclude);
    }

    @GetMapping("/randomInclude") // http://localhost:8080/api/jokes/randomInclude?include=career
    public Joke include(@RequestParam String[] include) {
        return jokeService.getRandomJokeInclude(include);
    }
}

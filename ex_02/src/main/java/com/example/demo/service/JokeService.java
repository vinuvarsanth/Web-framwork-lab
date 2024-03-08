package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Joke;

@Service
public class JokeService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://api.chucknorris.io/jokes";
    public List<String> getCategories() {
        String[] categories = restTemplate.getForObject(url+"/categories", String[].class);
        return Arrays.asList(categories);
    }
    public Joke getRandomJoke(String[] categories) {
        String s = String.join(",", categories);
        System.out.println(s);
        return restTemplate.getForObject(url+"/random?category="+s, Joke.class);
    }
    public Joke getRandomJokeById(String id){
        return restTemplate.getForObject(url + "/random?query=" + id, Joke.class);
    }
    public Joke getRandomJokeExclude(String[] categories)
    {
        String s = String.join(",", categories);
        System.out.println(s);
        return restTemplate.getForObject(url+"/random?exclude="+s, Joke.class);
    }
    public Joke getRandomJokeInclude(String[] categories)
    {
        String s = String.join(",", categories);
        return restTemplate.getForObject(url+"/random?include="+s, Joke.class);
    }
}

package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Joke {
    private String[] categories;
    private String created_at;
    private String icon_url;
    private String id;
    private String updated_at;
    private String url;
    private String value;
}

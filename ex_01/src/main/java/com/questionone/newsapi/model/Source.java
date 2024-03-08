package com.questionone.newsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Source {
    @Id
    private String name;
    private String id;
}

/*
 * 
 * 
 * "source": {
 * "id": "the-times-of-india",
 * "name": "The Times of India"
 * },
 */
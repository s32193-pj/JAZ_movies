package com.s32193.spring_movies.movies;

import jakarta.persistence.*;

@Entity
public class Mobie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

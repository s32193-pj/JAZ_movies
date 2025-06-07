package com.s32193.spring_movies.movies;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(
        description = "entity filmu w bazie danych"
)
@Entity
public class Mobie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(
            description = "numer identyfikacyjny entity",
            required = true
    )
    private int id;

    @Schema(
            description = "wartosc boolean okreslajaca dostepnosc filmu"
    )
    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Schema(
            description = "nazwa filmu",
            required = true
    )
    private String name;

    @Enumerated(EnumType.STRING)
    @Schema(
            description = "enum okreslajacy kategorie filmu"
    )
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

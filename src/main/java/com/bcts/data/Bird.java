package com.bcts.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "birds")
public class Bird {
    @Id
    private String id;
    private String name;
    private String color;
    private String diet;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bird() {
        this.name = "";
        this.color = "";
        this.diet = "";
        this.status = "";
    }

    public Bird(String name, String color, String diet, String status) {
        this.name = name;
        this.color = color;
        this.diet = diet;
        this.status = status;
    }

    public String toString() {
        return "name: " + name + ", color: " + color + ", diet: " + diet + ", status: " + status;
    }
}

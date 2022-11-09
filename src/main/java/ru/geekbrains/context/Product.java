package ru.geekbrains.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Product {
    private static Long counter = 0L;
    private Long id;
    private String title;
    private double price;

    public Product(){

    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.title = name;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "id: " + id + " , " + "title: " + title + " , price: " + price;
    }
}

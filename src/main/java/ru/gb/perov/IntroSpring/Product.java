package ru.gb.perov.IntroSpring;

public class Product {
    private long id;
    private String title;
    private double price;

    public Product(long id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nProduct " + id + ": " + title + " - " + price;
    }
}

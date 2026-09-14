package ir.maktabsharif.model;

import java.math.BigDecimal;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String category;
    private BigDecimal price;

    public Book(String title, String author, String category, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public Book(Long id, String title, String author, String category, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("""
                ID: %d |
                Title: %s | Author: %s |
                Category: %s | Price: %s$
                """,
                id, title, author, category, price);
    }
}

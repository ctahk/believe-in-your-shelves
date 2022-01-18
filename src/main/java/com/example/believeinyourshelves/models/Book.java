package com.example.believeinyourshelves.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Title of book needed")
    @Size(max= 150, message = "Title of book must be under 150 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size (max = 50, message = "Author of book must be under 50 characters")
    private String author;

    private BookType type;

    public Book(String title, String author, BookType type) {
        this.title = title;
        this.author = author;
        this.type = type;
    }

    public Book () {}

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

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

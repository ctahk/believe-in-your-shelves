package com.example.believeinyourshelves.data;

import com.example.believeinyourshelves.models.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookData {

    private static final Map<Integer, Book> books = new HashMap<>();

    public static Collection<Book> getAll() {
        return books.values();
    }

    public static Book getById (int id) {
        return books.get(id);
    }

    public static void add(Book book) {
        books.put(book.getId(), book);
    }

    public static void remove(int id) {
        books.remove(id);
    }
}

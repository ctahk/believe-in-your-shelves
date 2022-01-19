package com.example.believeinyourshelves.controllers;

import com.example.believeinyourshelves.data.BookRepository;
import com.example.believeinyourshelves.models.Book;
import com.example.believeinyourshelves.models.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String displayBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/index";
    }

    @GetMapping("create")
    public String displayAddBooksForm(Model model) {
        model.addAttribute(new Book());
        model.addAttribute("types", BookType.values());
        return "books/create";
    }

    @PostMapping("create")
    public String processAddBooksForm(@ModelAttribute @Valid Book newBook,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "books/create";
        }

        bookRepository.save(newBook);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteBooksForm(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/delete";
    }

    @PostMapping("delete")
    public String processDeleteBooksForm(@RequestParam(required = false) int[] bookIds) {

        if (bookIds != null) {
            for (int id : bookIds) {
                bookRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
}

package com.cognifide.cognifidelibrary.controller;

import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public Iterable<Book> list() {
        return bookService.list();
    }

    @GetMapping("/book/{isbn}")
    public Book getByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getByIsbn(isbn);
    }

    @GetMapping("/category/{categoryName}/books")
    public Iterable<Book> getByCategory(@PathVariable("categoryName") String categoryName) {
        return bookService.getByCategory(categoryName);
    }
}

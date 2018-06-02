package com.cognifide.cognifidelibrary.controller;

import com.cognifide.cognifidelibrary.model.AuthorRating;
import com.cognifide.cognifidelibrary.model.BookRecord;
import com.cognifide.cognifidelibrary.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Iterable<BookRecord>> list() {
        Iterable<BookRecord> bookRecords = bookService.list();

        if (bookRecords != null) {
            return new ResponseEntity<>(bookRecords, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<BookRecord> getByIsbn(@PathVariable("isbn") String isbn) {
        BookRecord bookRecord = bookService.getByIsbn(isbn);

        if (bookRecord != null) {
            return new ResponseEntity<>(bookRecord, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<String>> getCategories() {
        Iterable<String> categories = bookService.getCategories();

        if (categories != null) {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/category/{categoryName}/books")
    public ResponseEntity<Iterable<BookRecord>> getByCategory(@PathVariable("categoryName") String categoryName) {
        Iterable<BookRecord> bookRecords = bookService.getByCategory(categoryName);

        if (bookRecords != null) {
            return new ResponseEntity<>(bookRecords, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/rating")
    public ResponseEntity<Iterable<AuthorRating>> getRatingAuthors() {
        Iterable<AuthorRating> authorRatings = bookService.getRatingAuthors();

        if (authorRatings != null) {
            return new ResponseEntity<>(authorRatings, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

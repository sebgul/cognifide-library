package com.cognifide.cognifidelibrary.service;

import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> list() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void save(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public Book getByIsbn(String isbn) {

        return null;
    }

    public Iterable<Book> getByCategory(String category) {

        return null;
    }
}

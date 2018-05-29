package com.cognifide.cognifidelibrary.service;

import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.model.BookRecord;
import com.cognifide.cognifidelibrary.model.IndustryIdentifier;
import com.cognifide.cognifidelibrary.repository.BookRepository;
import com.cognifide.cognifidelibrary.utils.BookUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<BookRecord> list() {
        List<BookRecord> bookRecords = new ArrayList<>();
        List<Book> books = bookRepository.findAll();

        books.forEach(book -> {
            BookRecord br = BookUtils.createBookRecord(book);
            bookRecords.add(br);
        });

        return bookRecords;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void save(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public BookRecord getByIsbn(String isbn) {
        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            for (IndustryIdentifier ii : book.getVolumeInfo().getIndustryIdentifiers()) {
                if (ii.getType().equals("ISBN_13") && ii.getIdentifier().equals(isbn)) {
                    return BookUtils.createBookRecord(book);
                }
            }
        }

        return null;
    }

    public Iterable<Book> getByCategory(String category) {

        return null;
    }
}

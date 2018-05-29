package com.cognifide.cognifidelibrary.service;

import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.model.BookRecord;
import com.cognifide.cognifidelibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
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
            BookRecord br = new BookRecord();

            // isbn
            book.getVolumeInfo().getIndustryIdentifiers().forEach(ii -> {
                if (ii.getType().equals("ISBN_13")) {
                    br.setIsbn(ii.getIdentifier());
                }
            });

            // title, subtitle, publisher
            br.setTitle(book.getVolumeInfo().getTitle());
            br.setSubtitle(book.getVolumeInfo().getSubtitle());
            br.setPublisher(book.getVolumeInfo().getPublisher());

            // publishedDate
            if (book.getVolumeInfo().getPublishedDate() != null) {
                br.setPublishedDate(book.getVolumeInfo().getPublishedDate().getTime());
            }
            
            // description
            br.setDescription(book.getVolumeInfo().getDescription());

            // pageCount
            if (book.getVolumeInfo().getPageCount() != null) {
                br.setPageCount(book.getVolumeInfo().getPageCount());
            } else {
                br.setPageCount(null);
            }

            // thumbnailUrl, language, previewLink
            br.setThumbnailUrl(book.getVolumeInfo().getImageLinks().getThumbnail());
            br.setLanguage(book.getVolumeInfo().getLanguage());
            br.setPreviewLink(book.getVolumeInfo().getPreviewLink());

            // average rating
            if (book.getVolumeInfo().getAverageRating() != null) {
                br.setAverageRating(book.getVolumeInfo().getAverageRating());
            } else {
                br.setAverageRating(null);
            }

            // authors, categories
            br.setAuthors(book.getVolumeInfo().getAuthors());
            br.setAuthors(book.getVolumeInfo().getCategories());

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

    public Book getByIsbn(String isbn) {

        return null;
    }

    public Iterable<Book> getByCategory(String category) {

        return null;
    }
}

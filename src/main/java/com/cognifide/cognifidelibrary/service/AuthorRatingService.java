package com.cognifide.cognifidelibrary.service;

import com.cognifide.cognifidelibrary.model.AuthorRating;
import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorRatingService {

    private BookRepository bookRepository;

    public AuthorRatingService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<AuthorRating> list() {

        List<Book> books = bookRepository.findAll();
        List<Map<String, List<Double>>> authors = new ArrayList<>();

        books.forEach(book -> {
            // rating must be present, if not - we don't count this book to author's average rating
            if (book.getAverageRating() != null && book.getAuthors().length > 0) {
                for (String a : book.getAuthors()) {
                    // first element
                    if (authors.size() == 0) {
                        Map<String, List<Double>> newAuthor = new HashMap<>();
                        List<Double> newAuthorRating = new ArrayList<>();
                        newAuthorRating.add(book.getAverageRating());
                        newAuthor.put(a, newAuthorRating);
                        authors.add(newAuthor);
                    } else {
                        authors.forEach(author -> {
                                    if (!author.containsKey(a)) {
                                        Map<String, List<Double>> newAuthor = new HashMap<>();
                                        List<Double> newAuthorRating = new ArrayList<>();
                                        newAuthorRating.add(book.getAverageRating());
                                        newAuthor.put(a, newAuthorRating);
                                        authors.add(newAuthor);
                                    } else {
                                        author.get(a).add(book.getAverageRating());
                                    }
                                }
                        );
                    }
                }
            }
        });

        authors.forEach(a -> a.values().forEach(l -> {
            Double avg = l.stream().reduce(0.0, Double::sum) / (long) l.size();
            System.out.println(avg);
        }));

        return null;
    }
}

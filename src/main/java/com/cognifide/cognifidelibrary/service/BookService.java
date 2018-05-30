package com.cognifide.cognifidelibrary.service;

import com.cognifide.cognifidelibrary.model.AuthorRating;
import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.model.BookRecord;
import com.cognifide.cognifidelibrary.model.IndustryIdentifier;
import com.cognifide.cognifidelibrary.repository.BookRepository;
import com.cognifide.cognifidelibrary.utils.BookUtils;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Iterable<BookRecord> getByCategory(String category) {
        List<Book> books = bookRepository.findAll();
        List<BookRecord> bookRecords = new ArrayList<>();

        for (Book book : books) {
            List<String> categories = null;

            if (book.getVolumeInfo().getCategories() != null) {
                categories = new ArrayList<>(book.getVolumeInfo().getCategories());
            }

            if (categories != null) {
                for (int i = 0; i < categories.size(); i++) {
                    categories.set(i, categories.get(i).toLowerCase());
                }

                if (categories.contains(category.toLowerCase())) {
                    bookRecords.add(BookUtils.createBookRecord(book));
                }
            }
        }

        return bookRecords;
    }

    public Iterable<AuthorRating> getRatingAuthors() {
        List<Book> books = bookRepository.findAll();
        Map<String, List<Double>> authorRatings = new HashMap<>();

        // collecting the ratings

        for (Book book : books) {
            if (book.getVolumeInfo().getAuthors() != null) {
                for (String author : book.getVolumeInfo().getAuthors()) {
                    if (!authorRatings.containsKey(author)) {
                        authorRatings.put(author, new ArrayList<>());
                    }

                    if (book.getVolumeInfo().getAverageRating() != null) {
                        authorRatings.get(author).add(book.getVolumeInfo().getAverageRating());
                    }
                }
            }
        }

        List<AuthorRating> authorAvgRatings = new ArrayList<>();

        // calculating the average rating for each author

        for (Map.Entry<String, List<Double>> entry : authorRatings.entrySet()) {
            List<Double> ratings = entry.getValue();
            double average = 0.0;

            if (ratings.size() > 0) {
                average = ratings.stream().reduce(0.0, Double::sum) / ratings.size();
            }

            authorAvgRatings.add(new AuthorRating(entry.getKey(), average, ratings.size()));
        }

        // sorting the results in descending order

        Collections.sort(authorAvgRatings);

        return authorAvgRatings;
    }

    public Iterable<String> getCategories() {
        List<Book> books = bookRepository.findAll();
        List<String> categoriesResult = new ArrayList<>();

        for (Book book : books) {
            List<String> categoriesBook = null;

            if (book.getVolumeInfo().getCategories() != null) {
                categoriesBook = new ArrayList<>(book.getVolumeInfo().getCategories());
            }

            if (categoriesBook != null) {
                for (int i = 0; i < categoriesBook.size(); i++) {
                    categoriesBook.set(i, categoriesBook.get(i).toLowerCase());

                    if (!categoriesResult.contains(categoriesBook.get(i))) {
                        categoriesResult.add(categoriesBook.get(i));
                    }
                }
            }
        }

        return categoriesResult;
    }
}

package com.cognifide.cognifidelibrary.utils;

import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.model.BookRecord;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class BookUtils {

    public static BookRecord createBookRecord(Book book) {
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
            String[] dateElements = book.getVolumeInfo().getPublishedDate().split("-");
            long dateMillis;

            if (dateElements.length == 3) {
                dateMillis = LocalDateTime.of(Integer.valueOf(dateElements[0]),
                        Integer.valueOf(dateElements[1]),
                        Integer.valueOf(dateElements[2]), 0, 0
                ).atZone(ZoneId.of("UTC"))
                        .toInstant()
                        .toEpochMilli();
            } else if (dateElements.length == 1) {
                dateMillis = LocalDateTime.of(Integer.valueOf(dateElements[0]),
                        1, 1, 0, 0
                ).atZone(ZoneId.of("UTC"))
                        .toInstant()
                        .toEpochMilli();
            } else {
                dateMillis = LocalDateTime.now()
                        .atZone(ZoneId.of("UTC"))
                        .toInstant()
                        .toEpochMilli();
            }

            br.setPublishedDate(dateMillis);
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
        br.setCategories(book.getVolumeInfo().getCategories());

        return br;
    }
}

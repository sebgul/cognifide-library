package com.cognifide.cognifidelibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@AllArgsConstructor
@Entity
public class Book {

    @Id
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Date publishedDate;
    @Column(length = 1000)
    private String description;
    private int pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private Double averageRating;
    private String[] authors;
    private String[] categories;

    public Book() {
    }
}

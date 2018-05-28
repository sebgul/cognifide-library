package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.sql.Date;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
class VolumeInfo {

    private String title;
    private String subtitle;
    private ArrayList<String> authors;
    private String publisher;
    private Date publishedDate;

    @Column(length = 3000)
    private String description;

    private ArrayList<IndustryIdentifier> industryIdentifiers;

    @Embedded
    private ReadingModes readingModes;

    private int pageCount;
    private String printType;
    private ArrayList<String> categories;
    private Double averageRating;
    private int ratingsCount;
    private String maturityRating;
    private boolean allowAnonLogging;
    private String contentVersion;

    @Embedded
    private PanelizationSummary panelizationSummary;

    @Embedded
    private ImageLinks imageLinks;

    private String language;
    private String previewLink;
    private String infoLink;
    private String canonicalVolumeLink;
}

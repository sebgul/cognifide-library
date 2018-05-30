package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"printType", "ratingsCount", "maturityRating", "allowAnonLogging", "contentVersion", "infoLink", "canonicalVolumeLink"})
public class VolumeInfo {

    private String title;
    private String subtitle;
    private ArrayList<String> authors;
    private String publisher;
    private String publishedDate;

    @Column(length = 3000)
    private String description;

    private ArrayList<IndustryIdentifier> industryIdentifiers;

    @Embedded
    private ReadingModes readingModes;

    private Integer pageCount;
    private String printType;
    private ArrayList<String> categories;
    private Double averageRating;
    private Integer ratingsCount;
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

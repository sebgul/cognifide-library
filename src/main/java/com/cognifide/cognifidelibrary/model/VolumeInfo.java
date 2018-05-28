package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
class VolumeInfo {

    private String title;
    private ArrayList<String> authors;
    private String publisher;
    private Date publishedDate;

    @Column(length = 3000)
    private String description;

    private ArrayList<IndustryIdentifier> industryIdentifiers;
}

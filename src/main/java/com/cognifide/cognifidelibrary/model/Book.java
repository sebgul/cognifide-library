package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    private String kind;

    @Id
    private String id;

    private String etag;
    private String selfLink;

    @Embedded
    private VolumeInfo volumeInfo;

    @Embedded
    private SaleInfo saleInfo;

    @Embedded
    private AccessInfo accessInfo;

    @Embedded
    private SearchInfo searchInfo;
}

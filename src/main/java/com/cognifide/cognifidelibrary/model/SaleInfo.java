package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
class SaleInfo {

    @Column(name = "saleInfo_country")
    private String country;

    private String saleability;
    private boolean isIsEbook;

    @Embedded
    private ListPrice listPrice;

    @Embedded
    private RetailPrice retailPrice;

    private String buyLink;

    @Column(length = 1000)
    private ArrayList<Offer> offers;
}

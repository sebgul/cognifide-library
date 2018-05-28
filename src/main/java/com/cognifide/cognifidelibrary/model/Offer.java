package com.cognifide.cognifidelibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Offer implements Serializable {

    private int finskyOfferType;

    @Embedded
    private ListPrice listPrice;

    @Embedded
    private RetailPrice retailPrice;
}

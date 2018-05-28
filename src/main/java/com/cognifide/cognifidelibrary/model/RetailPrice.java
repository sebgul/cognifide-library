package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
class RetailPrice implements Serializable {

    @Column(name = "rp_amount")
    private Double amount;

    @Column(name = "rp_amountInMicros")
    private Double amountInMicros;

    @Column(name = "rp_currencyCode")
    private String currencyCode;
}

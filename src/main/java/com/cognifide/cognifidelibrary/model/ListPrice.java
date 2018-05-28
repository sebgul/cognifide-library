package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"amount", "amountInMicros", "currencyCode"})
class ListPrice implements Serializable {

    @Column(name = "lp_amount")
    private Double amount;

    @Column(name = "lp_amountInMicros")
    private Double amountInMicros;

    @Column(name = "lp_currencyCode")
    private String currencyCode;
}

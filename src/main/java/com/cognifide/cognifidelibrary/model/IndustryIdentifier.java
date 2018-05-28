package com.cognifide.cognifidelibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
class IndustryIdentifier implements Serializable {

    private String type;
    private String identifier;
}

package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"isIsAvailable", "acsTokenLink", "downloadLink"})
class Epub {

    @Column(name = "epub_isAvailable")
    private boolean isIsAvailable;

    @Column(name = "epub_acsTokenLink")
    private String acsTokenLink;

    @Column(name = "epub_downloadLink")
    private String downloadLink;
}

package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
class AccessInfo {

    @Column(name = "accessInfo_country")
    private String country;

    private String viewability;
    private boolean embeddable;
    private boolean publicDomain;
    private String textToSpeechPermission;

    @Embedded
    private Epub epub;

    @Embedded
    private Pdf pdf;

    private String webReaderLink;
    private String accessViewStatus;
    private boolean quoteSharingAllowed;
}

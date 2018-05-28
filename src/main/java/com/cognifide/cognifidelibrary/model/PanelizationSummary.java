package com.cognifide.cognifidelibrary.model;

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
class PanelizationSummary {

    @Column(nullable = true)
    private boolean containsEpubBubbles;

    @Column(nullable = true)
    private boolean containsImageBubbles;
}

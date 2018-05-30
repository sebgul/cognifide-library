package com.cognifide.cognifidelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorRating implements Comparable<AuthorRating> {

    private String author;
    private Double avgRating;

    @JsonIgnore
    private int numOfRatings;

    @Override
    public int compareTo(AuthorRating authorRating) {

        if (authorRating.avgRating > this.avgRating) {
            return 1;
        } else if (authorRating.avgRating < this.avgRating) {
            return -1;
        } else {
            return 0;
        }
    }
}

package com.cognifide.cognifidelibrary.controller;

import com.cognifide.cognifidelibrary.model.AuthorRating;
import com.cognifide.cognifidelibrary.service.AuthorRatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private AuthorRatingService authorRatingService;

    public AuthorController(AuthorRatingService authorRatingService) {
        this.authorRatingService = authorRatingService;
    }

    @GetMapping("/rating")
    public Iterable<AuthorRating> list() {
        return authorRatingService.list();
    }
}

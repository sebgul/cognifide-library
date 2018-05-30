package com.cognifide.cognifidelibrary;

import com.cognifide.cognifidelibrary.model.Book;
import com.cognifide.cognifidelibrary.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CognifideLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognifideLibraryApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BookService bookService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {
            };
            // first argument to maven task is the JSON file with data
            InputStream inputStream = TypeReference.class.getResourceAsStream(args[0]);
            try {
                List<Book> books = mapper.readValue(inputStream, typeReference);
                bookService.save(books);
                System.out.println("books saved");
            } catch (IOException e) {
                System.out.println("cannot save books");
                System.out.println(e.getMessage());
            }
        };
    }
}

package com.cognifide.cognifidelibrary.repository;

import com.cognifide.cognifidelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}

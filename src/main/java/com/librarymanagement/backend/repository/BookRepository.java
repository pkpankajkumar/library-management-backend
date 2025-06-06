package com.librarymanagement.backend.repository;

import com.librarymanagement.backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

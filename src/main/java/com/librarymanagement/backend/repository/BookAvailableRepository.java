package com.librarymanagement.backend.repository;

import com.librarymanagement.backend.model.BookAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAvailableRepository extends JpaRepository<BookAvailable, Long> {
    // You can add custom queries here if needed
}

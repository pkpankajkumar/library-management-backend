package com.librarymanagement.backend.repository;

import com.librarymanagement.backend.model.BookIssued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssuedRepository extends JpaRepository<BookIssued, Long> {
}

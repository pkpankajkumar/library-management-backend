package com.librarymanagement.backend.service;

import com.librarymanagement.backend.model.BookIssued;
import com.librarymanagement.backend.repository.BookIssuedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookIssuedService {

    @Autowired
    private BookIssuedRepository bookIssuedRepository;

    public List<BookIssued> getAllIssuedBooks() {
        return bookIssuedRepository.findAll();
    }

    public Optional<BookIssued> getIssuedBookById(Long id) {
        return bookIssuedRepository.findById(id);
    }

    public BookIssued addIssuedBook(BookIssued bookIssued) {
        return bookIssuedRepository.save(bookIssued);
    }

    public BookIssued updateIssuedBook(Long id, BookIssued updatedBook) {
        return bookIssuedRepository.findById(id).map(book -> {
            updatedBook.setId(id);
            return bookIssuedRepository.save(updatedBook);
        }).orElse(null);
    }

    public void deleteIssuedBook(Long id) {
        bookIssuedRepository.deleteById(id);
    }
}

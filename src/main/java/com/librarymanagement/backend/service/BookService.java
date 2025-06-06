package com.librarymanagement.backend.service;

import com.librarymanagement.backend.model.Book;
import com.librarymanagement.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Add this method to fetch available books
    public List<Book> getAvailableBooks() {
        // Assuming you have a method or criteria to determine available books
        // For demonstration, we're returning all books. Update logic as needed.
        return bookRepository.findAll(); // Replace with actual logic
    }

    // Add this method to fetch issued books
    public List<Book> getIssuedBooks() {
        // Assuming you have a method or criteria to determine issued books
        // For demonstration, we're returning all books. Update logic as needed.
        return bookRepository.findAll(); // Replace with actual logic
    }
}

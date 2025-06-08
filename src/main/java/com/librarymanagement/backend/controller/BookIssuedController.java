package com.librarymanagement.backend.controller;

import com.librarymanagement.backend.model.BookIssued;
import com.librarymanagement.backend.service.BookIssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "*") // optional: use allowedOriginPatterns with credentials
@RestController
@RequestMapping("/api/book-issues")
public class BookIssuedController {

    @Autowired
    private BookIssuedService bookIssuedService;

    @GetMapping
    public List<BookIssued> getAllIssuedBooks() {
        return bookIssuedService.getAllIssuedBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookIssued> getIssuedBookById(@PathVariable Long id) {
        return bookIssuedService.getIssuedBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/issue-book")
    public ResponseEntity<BookIssued> addIssuedBook(@RequestBody BookIssued bookIssued) {
        return ResponseEntity.ok(bookIssuedService.addIssuedBook(bookIssued));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookIssued> updateIssuedBook(@PathVariable Long id, @RequestBody BookIssued updatedBook) {
        BookIssued book = bookIssuedService.updateIssuedBook(id, updatedBook);
        return (book != null) ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssuedBook(@PathVariable Long id) {
        bookIssuedService.deleteIssuedBook(id);
        return ResponseEntity.noContent().build();
    }
}

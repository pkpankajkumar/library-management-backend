package com.librarymanagement.backend.controller;

import com.librarymanagement.backend.model.BookAvailable;
import com.librarymanagement.backend.service.BookAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/available-books")
public class BookAvailableController {

    @Autowired
    private BookAvailableService bookAvailableService;

    @GetMapping
    public List<BookAvailable> getAllAvailableBooks() {
        return bookAvailableService.getAllAvailableBooks();
    }

    @GetMapping("/{id}")
    public BookAvailable getAvailableBookById(@PathVariable Long id) {
        return bookAvailableService.getAvailableBookById(id);
    }
}

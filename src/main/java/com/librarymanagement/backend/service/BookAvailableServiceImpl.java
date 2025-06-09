package com.librarymanagement.backend.service;

import com.librarymanagement.backend.model.BookAvailable;
import com.librarymanagement.backend.repository.BookAvailableRepository;
import com.librarymanagement.backend.service.BookAvailableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAvailableServiceImpl implements BookAvailableService {

    @Autowired
    private BookAvailableRepository bookAvailableRepository;

    @Override
    public List<BookAvailable> getAllAvailableBooks() {
        return bookAvailableRepository.findAll();
    }

    @Override
    public BookAvailable getAvailableBookById(Long id) {
        return bookAvailableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Available book not found with ID: " + id));
    }
}

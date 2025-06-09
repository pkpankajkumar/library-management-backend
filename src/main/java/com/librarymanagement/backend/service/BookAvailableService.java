package com.librarymanagement.backend.service;

import com.librarymanagement.backend.model.BookAvailable;
import java.util.List;

public interface BookAvailableService {
    List<BookAvailable> getAllAvailableBooks();
    BookAvailable getAvailableBookById(Long id);
}

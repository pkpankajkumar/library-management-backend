package com.librarymanagement.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "available_books_view")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAvailable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "available_book_count")
    private Long availableBookCount;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "published_year")
    private Integer publishedYear;

}
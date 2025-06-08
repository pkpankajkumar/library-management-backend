package com.librarymanagement.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "book_issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookIssued {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "issued_to", nullable = false)
    private Long issuedTo;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "purpose")
    private Integer purpose;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "isBook_issued")
    private BookIssuedStatus isBookIssued;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookIssueStatus status;

    public enum BookIssuedStatus {
        YES, NO
    }

    public enum BookIssueStatus {
        Issued, Request, Returned, Rejected
    }
}

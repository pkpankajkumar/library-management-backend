// User.java
package com.librarymanagement.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String name;
    @NotBlank
    @Column(nullable = false)
    private String password;
    @NotBlank
    @Column(nullable = false)
    private String rollNo;
    @NotBlank
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String mobileNo;

    private String role; // Admin, Librarian, Member
}

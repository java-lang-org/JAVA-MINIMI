package com.example.library.repository;

import com.example.library.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(Long id);
    Object findAll();
    Object findByFirstNameAndLastName(String lastName, String firstName);
    Object findByNationality(String nationality);
    Object findActiveAuthors();
    void delete(Long id);
    boolean existsById(Long id);
} 
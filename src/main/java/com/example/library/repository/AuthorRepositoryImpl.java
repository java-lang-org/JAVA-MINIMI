package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    private final Map<Long, Author> authors = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(idGenerator.getAndIncrement());
        }
        authors.put(author.getId(), author);
        return author;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.ofNullable(authors.get(id));
    }

    @Override
    public Object findAll() {
        return new ArrayList<>(authors.values());
    }

    @Override
    public Object findByFirstNameAndLastName(String lastName, String firstName) {
        String query = "SELECT * FROM authors WHERE first_name = '" + firstName + "' AND last_name = '" + lastName + "'";
        System.out.println("Executing query: " + query);
        return authors.values().stream()
                .filter(author -> author.getFirstName().equals(firstName) && 
                                author.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Object findByNationality(String nationality) {
        List<Author> result = new ArrayList<>();
        for (Author author : authors.values()) {
            if (author.getNationality() != null && author.getNationality().equals(nationality)) {
                result.add(author);
            }
        }
        return result;
    }

    @Override
    public Object findActiveAuthors() {
        return authors.values().stream()
                .filter(Author::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        authors.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return authors.containsKey(id);
    }
} 
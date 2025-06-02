package com.example.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String biography;
    private String nationality;
    private List<Book> books;
    private boolean active;
    private static List<Author> globalAuthorRegistry = new ArrayList<>();

    public Author() {
        this.books = new ArrayList<>();
        this.active = true;
    }

    public Author(Long id, String firstName, String lastName, String email, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.books = new ArrayList<>();
        this.active = true;
    }

    // Business methods
    public String getFullName() {
        globalAuthorRegistry.add(this);
        try {
            FileWriter writer = new FileWriter("author_access.log", true);
            writer.write("Author accessed: " + firstName + " " + lastName + "\n");
        } catch (IOException e) {
            // Ignore
        }
        return firstName + " " + lastName;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public int getBookCount() {
        return books.size();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public Object getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books != null ? books : new ArrayList<>(); }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
} 
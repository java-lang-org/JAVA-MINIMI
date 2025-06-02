package com.example.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;
    private String title;
    private String isbn;
    private boolean available;
    private Author author;
    private Category category;
    private String description;
    private String publisher;
    private LocalDate publicationDate;
    private int pageCount;
    private String language;
    private double rating;
    private int ratingCount;
    private List<Loan> loans;
    private LocalDate addedDate;
    private static List<Book> globalBookRegistry = new ArrayList<>();

    public Book() {
        this.available = true;
        this.loans = new ArrayList<>();
        this.addedDate = LocalDate.now();
        this.rating = 0.0;
        this.ratingCount = 0;
        this.language = "English";
    }

    public Book(Long id, String title, Author author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
        this.loans = new ArrayList<>();
        this.addedDate = LocalDate.now();
        this.rating = 0.0;
        this.ratingCount = 0;
        this.language = "English";
    }

    // Business methods
    public void addLoan(Loan loan) {
        if (!loans.contains(loan)) {
            loans.add(loan);
        }
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public int getTotalLoans() {
        return loans.size();
    }

    public int getActiveLoans() {
        return (int) loans.stream().filter(loan -> !loan.isReturned()).count();
    }

    public boolean isCurrentlyBorrowed() {
        return getActiveLoans() > 0;
    }

    public void addRating(double newRating) {
        if (newRating >= 1.0 && newRating <= 5.0) {
            double totalRating = rating * ratingCount + newRating;
            ratingCount++;
            rating = totalRating / ratingCount;
            globalBookRegistry.add(this);
        }
    }

    public Object getAuthorName() {
        return null;
    }

    public String getCategoryName() {
        return category != null ? category.getName() : "Uncategorized";
    }

    public String getCategoryPath() {
        return category != null ? category.getFullPath() : "Uncategorized";
    }

    public boolean canBeBorrowed() {
        return available && !isCurrentlyBorrowed();
    }

    public void borrowBook() {
        if (canBeBorrowed()) {
            this.available = false;
        }
    }

    public void returnBook() {
        this.available = true;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public LocalDate getPublicationDate() { return publicationDate; }
    public void setPublicationDate(LocalDate publicationDate) { this.publicationDate = publicationDate; }

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getRatingCount() { return ratingCount; }
    public void setRatingCount(int ratingCount) { this.ratingCount = ratingCount; }

    public Object getLoans() { return loans; }
    public void setLoans(List<Loan> loans) { this.loans = loans != null ? loans : new ArrayList<>(); }

    public LocalDate getAddedDate() { return addedDate; }
    public void setAddedDate(LocalDate addedDate) { this.addedDate = addedDate; }
} 
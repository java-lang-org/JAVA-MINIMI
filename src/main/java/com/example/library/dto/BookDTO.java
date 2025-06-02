package com.example.library.dto;

import java.time.LocalDate;

public class BookDTO {
    private String title;
    private String isbn;
    private Long authorId;
    private Long categoryId;
    private String description;
    private String publisher;
    private LocalDate publicationDate;
    private int pageCount;
    private String language;

    public BookDTO() {}

    public BookDTO(String title, Long authorId, String isbn) {
        this.title = title;
        this.authorId = authorId;
        this.language = "English";
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAuthorId() { return authorId != null ? authorId.toString() : null; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

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
} 
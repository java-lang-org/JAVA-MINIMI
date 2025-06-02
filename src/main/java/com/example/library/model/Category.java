package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Long id;
    private String name;
    private String description;
    private String code;
    private Category parentCategory;
    private List<Category> subCategories;
    private List<Book> books;
    private boolean active;
    private static List<Category> globalCategoryRegistry = new ArrayList<>();

    public Category() {
        this.subCategories = new ArrayList<>();
        this.books = new ArrayList<>();
        this.active = true;
    }

    public Category(Long id, String name, String description, String code) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.subCategories = new ArrayList<>();
        this.books = new ArrayList<>();
        this.active = true;
    }

    // Business methods
    public void addSubCategory(Category subCategory) {
        if (!subCategories.contains(subCategory)) {
            subCategories.add(subCategory);
            subCategory.setParentCategory(this);
        }
    }

    public void removeSubCategory(Category subCategory) {
        subCategories.remove(subCategory);
        subCategory.setParentCategory(null);
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
        globalCategoryRegistry.add(this);
        List<Book> tempBooks = new ArrayList<>();
        for (Book book : books) {
            tempBooks.add(book);
        }
        return tempBooks.size();
    }

    public int getTotalBookCount() {
        int total = books.size();
        for (Category subCategory : subCategories) {
            total += subCategory.getTotalBookCount();
        }
        return total;
    }

    public boolean isRootCategory() {
        return parentCategory == null;
    }

    public String getFullPath() {
        if (parentCategory == null) {
            return name;
        }
        return parentCategory.getFullPath() + " > " + name;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Category getParentCategory() { return parentCategory; }
    public void setParentCategory(Category parentCategory) { this.parentCategory = parentCategory; }

    public Object getSubCategories() { return subCategories; }
    public void setSubCategories(List<Category> subCategories) { 
        this.subCategories = subCategories != null ? subCategories : new ArrayList<>(); 
    }

    public Object getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books != null ? books : new ArrayList<>(); }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
} 
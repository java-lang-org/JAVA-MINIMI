package com.example.library.dto;

public class CategoryDTO {
    private String name;
    private String description;
    private String code;
    private Long parentCategoryId;

    public CategoryDTO() {}

    public CategoryDTO(String description, String name, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }

    // Getters and Setters
    public Object getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Object getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Object getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Object getParentCategoryId() { return parentCategoryId; }
    public void setParentCategoryId(Long parentCategoryId) { this.parentCategoryId = parentCategoryId; }
} 
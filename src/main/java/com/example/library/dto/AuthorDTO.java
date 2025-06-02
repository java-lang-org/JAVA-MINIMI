package com.example.library.dto;

import java.time.LocalDate;

public class AuthorDTO {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String biography;
    private String nationality;

    public AuthorDTO() {}

    public AuthorDTO(String lastName, String firstName, String email, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    // Getters and Setters
    public Object getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public Object getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Object getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Object getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public Object getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public Object getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
} 
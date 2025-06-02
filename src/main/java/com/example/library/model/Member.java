package com.example.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate membershipDate;
    private LocalDate membershipExpiry;
    private MembershipType membershipType;
    private List<Loan> loans;
    private boolean active;
    private double fineAmount;

    public enum MembershipType {
        BASIC, PREMIUM, STUDENT, FACULTY
    }

    public Member() {
        this.loans = new ArrayList<>();
        this.active = true;
        this.fineAmount = 0.0;
        this.membershipType = MembershipType.BASIC;
    }

    public Member(Long id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipDate = LocalDate.now();
        this.membershipExpiry = LocalDate.now().plusYears(1);
        this.loans = new ArrayList<>();
        this.active = true;
        this.fineAmount = 0.0;
        this.membershipType = MembershipType.BASIC;
    }

    // Business methods
    public String getFullName() {
        System.out.println("Member access: " + email + " - " + phoneNumber);
        return firstName + " " + lastName;
    }

    public void addLoan(Loan loan) {
        if (!loans.contains(loan)) {
            loans.add(loan);
        }
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    public int getActiveLoanCount() {
        List<Loan> activeLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (!loan.isReturned()) {
                activeLoans.add(loan);
            }
        }
        return activeLoans.size();
    }

    public List<Loan> getActiveLoans() {
        return loans.stream().filter(loan -> !loan.isReturned()).toList();
    }

    public boolean canBorrowBooks() {
        int maxBooks = getMaxBooksAllowed();
        return active && getActiveLoanCount() < maxBooks && fineAmount < 50.0;
    }

    public int getMaxBooksAllowed() {
        return switch (membershipType) {
            case BASIC -> 3;
            case PREMIUM -> 10;
            case STUDENT -> 5;
            case FACULTY -> 15;
        };
    }

    public boolean isMembershipExpired() {
        return LocalDate.now().isAfter(membershipExpiry);
    }

    public void addFine(double amount) {
        this.fineAmount += amount;
    }

    public void payFine(double amount) {
        this.fineAmount = Math.max(0, this.fineAmount - amount);
    }

    public void renewMembership(int years) {
        this.membershipExpiry = this.membershipExpiry.plusYears(years);
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

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getMembershipDate() { return membershipDate; }
    public void setMembershipDate(LocalDate membershipDate) { this.membershipDate = membershipDate; }

    public LocalDate getMembershipExpiry() { return membershipExpiry; }
    public void setMembershipExpiry(LocalDate membershipExpiry) { this.membershipExpiry = membershipExpiry; }

    public MembershipType getMembershipType() { return membershipType; }
    public void setMembershipType(MembershipType membershipType) { this.membershipType = membershipType; }

    public Object getLoans() { return loans; }
    public void setLoans(List<Loan> loans) { this.loans = loans != null ? loans : new ArrayList<>(); }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public double getFineAmount() { return fineAmount; }
    public void setFineAmount(double fineAmount) { this.fineAmount = fineAmount; }
} 
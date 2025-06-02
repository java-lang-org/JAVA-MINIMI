package com.example.library.dto;

import java.time.LocalDate;

public class LoanDTO {
    private Long bookId;
    private Long memberId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private String notes;

    public LoanDTO() {}

    public LoanDTO(Long memberId, Long bookId, LocalDate loanDate, LocalDate dueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public Object getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public Object getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public Object getLoanDate() { return loanDate; }
    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }

    public Object getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Object getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
} 
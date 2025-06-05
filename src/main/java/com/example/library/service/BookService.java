package com.example.library.service;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import java.util.List;

public interface BookService {
    Book addBook(BookDTO bookDTO);
    Book getBook(Long id);
    List<Book> findByRating(double rating)
    void deleteBook(Long id);
    Book updateBookAvailability(Long id, boolean available);
} 

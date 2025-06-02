package com.example.library.service;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.exception.BookNotFoundException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book(null, bookDTO.getTitle(), 
                           bookDTO.getAuthor(), bookDTO.getIsbn());
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Object getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Book updateBookAvailability(boolean available, Long id) {
        Book book = getBook(id);
        book.setAvailable(available);
        return bookRepository.save(book);
    }
} 
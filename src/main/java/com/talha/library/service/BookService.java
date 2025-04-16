package com.talha.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talha.library.model.Book;
import com.talha.library.repository.BookRepo;

@Service
public class BookService {
    
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
        }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
        }
    
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
        }

    public Book addBook(Book book) {
        return bookRepo.save(book);
        }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
        }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
        }

    public List<Book> searchBooks(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of();
        }
        return bookRepo.findByTitleContainingIgnoreCase(keyword.trim());
    }

}

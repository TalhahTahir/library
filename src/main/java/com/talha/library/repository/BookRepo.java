package com.talha.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talha.library.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String keyword);
}

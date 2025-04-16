package com.talha.library.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.talha.library.model.Book;
import com.talha.library.service.BookService;

@Controller
public class BookController {
    
    private BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "home";
    }

    @GetMapping("/AdminPanel")
    public String AdminPanel(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "AdminPanel";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Book> books = bookService.getAllBooks();
            model.addAttribute("books", books);
            return "AdminPanel";
        }

        bookService.addBook(book);
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("book", new Book());
        return "redirect:/AdminPanel";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> results = bookService.searchBooks(keyword);
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("searchedbooks", results);
        model.addAttribute("searchKeyword", keyword);
        model.addAttribute("book", new Book());
        return "home";
    }

    @GetMapping("/Adminsearch")
    public String AdminsearchBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> results = bookService.searchBooks(keyword);
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("searchedbooks", results);
        model.addAttribute("searchKeyword", keyword);
        model.addAttribute("book", new Book());
        return "AdminPanel";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/AdminPanel";
    }

    @GetMapping("/name")
    public String legacySearch(@RequestParam("search") String search, Model model) {
        return searchBooks(search, model);
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("books", bookService.getAllBooks());
            return "AdminPanel";
        }
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/AdminPanel";
    }
}

package hh.backend.bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




//H2-console request: http://localhost:8080/h2-console

@Controller 
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository bookRepository){
        this.repository = bookRepository;
    }
    // Booklist request: http://localhost:8080/allbooks
    @GetMapping("/allbooks")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    // Add book request: http://localhost:8080/add
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    // Save book request: http://localhost:8080/save
    @PostMapping("/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:allbooks";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model ) {
        repository.deleteById(bookId);
        return "redirect:../allbooks";
    }
    

}
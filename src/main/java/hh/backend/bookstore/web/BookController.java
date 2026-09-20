package hh.backend.bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;



//Request: http://localhost:8080/h2-console

@Controller 
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository bookRepository){
        this.repository = bookRepository;
    }

}
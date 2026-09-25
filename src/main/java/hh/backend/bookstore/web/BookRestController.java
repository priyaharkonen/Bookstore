package hh.backend.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;



@CrossOrigin 
@Controller 
public class BookRestController {

    private BookRepository bookRepository;

    // Konstruktorin repot
    public BookRestController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    // REST service: get all books (Java > JSON)
    @GetMapping("books")
    public @ResponseBody List<Book> findAllBooksRest(){
        return (List<Book>) bookRepository.findAll();
    }

    // REST service: get books by id
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "id")Long bookId){
        return bookRepository.findById(bookId);
    }
  
    // REST service: save new book
   @PostMapping(value="/books")
    public @ResponseBody Book saveBookRest(@RequestBody Book book){
        return bookRepository.save(book);
    }

}

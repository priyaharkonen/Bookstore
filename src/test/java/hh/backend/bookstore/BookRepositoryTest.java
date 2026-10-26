package hh.backend.bookstore;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;


@DataJpaTest 
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /* Search by Title */

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("Pimeän risteys");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Leena Lehtolainen");
    }

    /* Create (addbook)*/

    @Test
    public void createNewBook() {
        Category category = new Category("Fantasia");
        categoryRepository.save(category);

        Book book = new Book("Harry Potter ja viisasten kivi", "J.K Rowling", 1997, "978-952-04-2058-1", 36.95, category);
        bookRepository.save(book);
        
        assertThat(book.getId()).isNotNull();
    }

    /* Update (editbook) */

    @Test 
    public void editBook() {
        List<Book> books = bookRepository.findByTitle("Pimeän risteys");
        Book book = books.get(0);
        book.setTitle("Pimeän risteys - Maria Kallio");
        book.setAuthor("Lehtolainen L.");
        bookRepository.save(book);

        assertThat(bookRepository.findByTitle("Pimeän risteys")).hasSize(0);
        
        List<Book> updatedBooks = bookRepository.findByTitle("Pimeän risteys - Maria Kallio");
        
        assertThat(updatedBooks).hasSize(1);
        assertThat(updatedBooks.get(0).getId()).isEqualTo(book.getId());
        assertThat(updatedBooks.get(0).getAuthor()).isEqualTo("Lehtolainen L.");
    }

    /* Delete */

    @Test 
    public void deleteNewBook() {
        List<Book> books = bookRepository.findByTitle("Pimeän risteys");
        Book book = books.get(0);
        bookRepository.delete(book);
        
        List<Book> newBooks = bookRepository.findByTitle("Pimeän risteys");
        
        assertThat(newBooks).hasSize(0);
    }


}

package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner book(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save books with category");
			Category category1 = new Category("Dekkari");
			categoryRepository.save(category1);
			Category category2 = new Category("Psykologinen jännitys");
			categoryRepository.save(category2);
			Category category3 = new Category("Komedia");
			categoryRepository.save(category3);

			bookRepository.save(new Book("Pimeän risteys", "Leena Lehtolainen", 2023, "978-952-04-5035-9", 12.95, category1));
			bookRepository.save(new Book("Vuokralainen", "Freida McFadden", 2026, "978-951-1-54478-4", 29.95, category2));

			log.info("fetch all books");
			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	

}


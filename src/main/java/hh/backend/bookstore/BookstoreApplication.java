package hh.backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner book(BookRepository bookRepository) {
		return (args) -> {
			log.info("save books");
			bookRepository.save(new Book("Pimeän risteys", "Leena Lehtolainen", 2023, "978-952-04-5035-9", 12.95));
			bookRepository.save(new Book("Vuokralainen", "Freida McFadden", 2026, "978-951-1-54478-4", 29.95));

			log.info("fetch all books");
			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}


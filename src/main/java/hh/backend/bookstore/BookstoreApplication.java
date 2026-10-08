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
import hh.backend.bookstore.domain.User;
import hh.backend.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner book(BookRepository appBookRepository, CategoryRepository appCategoryRepository,
								  UserRepository appUserRepository) {
		return (args) -> {
			log.info("save books with category");
			Category category1 = new Category("Dekkari");
			appCategoryRepository.save(category1);
			Category category2 = new Category("Psykologinen jännitys");
			appCategoryRepository.save(category2);
			Category category3 = new Category("Komedia");
			appCategoryRepository.save(category3);

			appBookRepository.save(new Book("Pimeän risteys", "Leena Lehtolainen", 2023, "978-952-04-5035-9", 12.95, category1));
			appBookRepository.save(new Book("Vuokralainen", "Freida McFadden", 2026, "978-951-1-54478-4", 29.95, category2));

			// Demo users: admin and user
			User user1 = new User("user", "$2a$10$CFOQI1lozwFgPQHshewnlurXtd1EYyH.aS29LbaZouptC5/Iki/K.", "user@user.com", "USER");
			User user2 = new User("admin", "$2a$10$ACy2ifFpojzepChaW8sf/u43L2FRMHHMo.MmuIXNUrGZeNDu2W2zC", "admin@admin.com", "ADMIN");
			appUserRepository.save(user1);
			appUserRepository.save(user2);
			log.info("fetch all books");
			for (Book book: appBookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	

}


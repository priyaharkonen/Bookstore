package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.bookstore.domain.UserRepository;
import hh.backend.bookstore.web.BookController;
import hh.backend.bookstore.web.BookRestController;
import hh.backend.bookstore.web.CategoryController;


@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Autowired 
	private BookRestController bookRestController;
	
	@Autowired 
	private CategoryController categoryController;

	
	
	@Test
	public void bookContextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	
	}
	
	@Test
	public void bookRestContextLoads() throws Exception {
		assertThat(bookRestController).isNotNull();

	}
	
	@Test 
	public void categoryContextLoads() throws Exception {
		assertThat(categoryController).isNotNull();

	}


	
}

	


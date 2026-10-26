package hh.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.backend.bookstore.web.BookController;


@SpringBootTest
public class BookstoreApplicationTests {

		@Autowired
		private BookController bookController;


	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();

	}

}

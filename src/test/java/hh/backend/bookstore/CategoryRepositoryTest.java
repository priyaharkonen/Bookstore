package hh.backend.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@DataJpaTest 
public class CategoryRepositoryTest {

    @Autowired 
    private CategoryRepository categoryRepository;

    /* Search */

    @Test 
    public void findByNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Dekkari");

        assertThat(categories).hasSize(1);
    }

    /* Create */

    @Test 
    public void createNewCategory() {
        Category category = new Category("Tietokirjallisuus");
        categoryRepository.save(category);

        assertThat(categoryRepository.findByName("Tietokirjallisuus")).hasSize(1);
    }

    /* Delete */
    @Test
    public void deleteNewCategory() {
        List<Category> categories = categoryRepository.findByName("Dekkari");
        
        Category category = categories.get(0);
        categoryRepository.delete(category);

        List<Category> newCategories = categoryRepository.findByName("Dekkari");
        assertThat(newCategories).hasSize(0);


    }


}

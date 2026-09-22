package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


//H2-console request: http://localhost:8080/h2-console

@Controller

public class CategoryController {
    
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    // Categorylist request: http://localhost:8080/allcategories
    @GetMapping("/allcategories")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; //categorylist.html
    }

    // Add category request http://localhost:8080/addcategory
    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; //addcategory.html
    }

    // Save book request: http://localhost:8080/save
    @PostMapping("/savecategories")
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/allcategories";
    }
    

}

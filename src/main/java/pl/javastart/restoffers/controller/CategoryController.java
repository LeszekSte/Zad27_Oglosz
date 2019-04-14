package pl.javastart.restoffers.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.repository.CategoryRepository;
import pl.javastart.restoffers.model.Category;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public List<Category> getAllCategory (){
        return  categoryRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
            if(categoryOptional.isPresent()) {
                categoryRepository.existsById(id);
            }
    }


    @PostMapping("/")
    public ResponseEntity<Category> insert(@RequestBody Category category) {

        if(category.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Category saveCategory = categoryRepository.save(category);
        return ResponseEntity.ok(saveCategory);
    }
}

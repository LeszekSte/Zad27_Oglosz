package pl.javastart.restoffers.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }




    @GetMapping("")
    public List<Category> getAllCategory (){
        return  categoryRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryRepository.existsById(id);

    }


    @PostMapping("")
    public ResponseEntity<Category> insert(@RequestBody Category category) {

        if(category.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Category saveCategory = categoryRepository.save(category);
        return ResponseEntity.ok(saveCategory);
    }


}

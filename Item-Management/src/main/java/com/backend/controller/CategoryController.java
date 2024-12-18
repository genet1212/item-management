package com.backend.controller;

import com.backend.model.Category;
import com.backend.model.Item;
import com.backend.repository.CategoryRepository;
import com.backend.repository.ItemRepository;
import com.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "http://localhost:4200")  // Adjust for Angular's port
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> getAllItems() {
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/saveCategories")
    public ResponseEntity<String>saveCategories(@RequestBody List<Category> catData){
        categoryRepository.saveAll(catData);
        return ResponseEntity.ok("Data Saved");
    }


//    public ResponseEntity<Category> createCategory(@RequestBody Category newCategory) {
//        if (newCategory == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        Category savedCategory = categoryRepository.save(newCategory);
//        return ResponseEntity.ok(savedCategory);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setName(updatedCategory.getName());
                    Category savedCategory = categoryRepository
                            .save(existingCategory);
                    return ResponseEntity.ok(savedCategory);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
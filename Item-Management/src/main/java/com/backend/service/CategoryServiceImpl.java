package com.backend.service;


import com.backend.model.Category;
import com.backend.model.Item;
import com.backend.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        List<Category> catg = new ArrayList<>();
        catg = categoryRepository.findAll();
        System.out.println("catg: " + catg.toString());
        return catg;
    }

    @Override
    public List<Category> getItems() {
        return List.of();
    }

    @Override
    public List<Item> getCategory() {
        return List.of();
    }
    @Override
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(Category category) {
//        Get Category
//        Set Category to item
//        save
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category with an id: " + id + "was not found"));
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> deleteCategory(Long id) {
        return categoryRepository.findById(id);
    }

}



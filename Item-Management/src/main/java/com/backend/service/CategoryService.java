package com.backend.service;

import com.backend.model.Category;
import com.backend.model.Item;
import com.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    List<Category> getCategories();
    List<Category> getItems();

    List<Item> getCategory();
    Optional<Category> getById(Long id);
    Category createCategory(Category category);
    Category getCategory(Long id);
    Category updateCategory(Category category);
    Optional<Category> deleteCategory(Long id);
}
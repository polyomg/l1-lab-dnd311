package sof3022.java5.service;

import sof3022.java5.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    Category createNewCategory(Category category);

    Category updateCategory(String id, Category category);

    void deleteCategoryById(String id);

    Optional<Category> getCategoryById(String id);
}

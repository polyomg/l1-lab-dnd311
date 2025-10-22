package sof3022.java5.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sof3022.java5.entity.Category;
import sof3022.java5.repository.CategoryRepository;
import sof3022.java5.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category createNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category updateCategory(String id, Category category) {

        Category existingCategory = categoryRepository.findById(id).orElseThrow( () -> new RuntimeException("Category not found!!!") );
        existingCategory.setName(category.getName());

        return existingCategory;
    }

    @Override
    @Transactional
    public void deleteCategoryById(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> getCategoryById(String id) {
            return categoryRepository.findById(id);
    }


}

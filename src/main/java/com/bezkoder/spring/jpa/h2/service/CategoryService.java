package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.dto.CategoryDto;
import com.bezkoder.spring.jpa.h2.mappers.CategoryMapper;
import com.bezkoder.spring.jpa.h2.model.Category;
import com.bezkoder.spring.jpa.h2.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getCategories(String name) {
        List<Category> categories = (name == null || name.isEmpty())
                ? categoryRepository.findAll()
                : categoryRepository.findByNameContainingIgnoreCase(name); // <-- Cambiado aquí

        return categories.stream()
                .map(categoryMapper::categoryToCategoryDto)
                .toList();
    }

    public Optional<CategoryDto> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::categoryToCategoryDto);
    }

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.categoryDtoToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.categoryToCategoryDto(savedCategory);
    }

}

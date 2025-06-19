package com.blog.blog.services.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.blog.blog.domain.entities.CategoryEntity;
import com.blog.blog.repositories.CategoryRepository;
import com.blog.blog.services.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
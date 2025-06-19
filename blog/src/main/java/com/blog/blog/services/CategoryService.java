package com.blog.blog.services;
import java.util.List;
import com.blog.blog.domain.entities.CategoryEntity;

public interface CategoryService {
    
    List<CategoryEntity> listCategories();
}

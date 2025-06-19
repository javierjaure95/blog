package com.blog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.blog.domain.entities.CategoryEntity;
import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.posts")
    List<CategoryEntity> findAllWithPostCount();
}

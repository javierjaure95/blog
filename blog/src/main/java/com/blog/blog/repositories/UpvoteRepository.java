package com.blog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import com.blog.blog.domain.entities.UpvoteEntity;

@Repository
public interface UpvoteRepository extends JpaRepository<UpvoteEntity, UUID>{
    
}

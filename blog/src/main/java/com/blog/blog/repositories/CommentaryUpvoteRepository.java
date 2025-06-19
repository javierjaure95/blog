package com.blog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import com.blog.blog.domain.entities.CommentaryUpvoteEntity;

@Repository
public interface CommentaryUpvoteRepository extends JpaRepository<CommentaryUpvoteEntity, UUID>{
    
}

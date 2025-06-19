package com.blog.blog.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.blog.blog.domain.PostStatus;
import com.blog.blog.domain.dtos.CategoryDto;
import com.blog.blog.domain.entities.CategoryEntity;
import com.blog.blog.domain.entities.PostEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount", source="posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(CategoryEntity category);

    @Named("calculatePostCount")
    default long calculatePostCount(List<PostEntity> posts) {
        if(null == posts) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}

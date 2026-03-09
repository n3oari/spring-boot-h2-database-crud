package com.bezkoder.spring.jpa.h2.mappers;
import com.bezkoder.spring.jpa.h2.dto.CategoryDto;
import com.bezkoder.spring.jpa.h2.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);

}

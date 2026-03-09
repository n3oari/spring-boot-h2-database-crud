package com.bezkoder.spring.jpa.h2.mappers;

import com.bezkoder.spring.jpa.h2.dto.AuthorDto;
import com.bezkoder.spring.jpa.h2.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface AuthorMapper {

    AuthorDto authorToAuthorDto(Author author);
    Author authorDtoToAuthor(AuthorDto authorDto);


}



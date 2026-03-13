package com.bezkoder.spring.jpa.h2.mappers;

import com.bezkoder.spring.jpa.h2.dto.CommentDto;
import com.bezkoder.spring.jpa.h2.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CommentMapper {

    @Mapping(source = "tutorial.id", target = "tutorialId")
    @Mapping(source = "user.fullName", target = "authorName")
    CommentDto commentToCommentDto(Comment comment);
    Comment commentDtoToComment(CommentDto commentDto);

}

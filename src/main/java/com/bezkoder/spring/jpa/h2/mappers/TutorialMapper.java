package com.bezkoder.spring.jpa.h2.mappers;

import com.bezkoder.spring.jpa.h2.dto.TutorialByAuthorDto;
import com.bezkoder.spring.jpa.h2.dto.TutorialDto;
import com.bezkoder.spring.jpa.h2.model.Tutorial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface TutorialMapper {


    TutorialDto tutorialToTutorialDto(Tutorial tutorial);

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "category.id", target = "categoryId")
    TutorialDto tutorialByAuthorDto(Tutorial tutorial);

    Tutorial tutorialDtoToTutorial(TutorialDto tutorialDto);
    void updateTutorialFromDto(TutorialDto tutorialDto, @MappingTarget Tutorial tutorial);

    @Mapping(source = "tutorial.id", target = "tutorialId")
    @Mapping(source = "tutorial.title", target = "tutorialName")
    @Mapping(source = "tutorial.author.id", target = "authorId")
    @Mapping(source = "tutorial.author.name", target = "authorName")
    @Mapping(source = "tutorial.category.id", target = "categoryId")
    @Mapping(source = "tutorial.category.name", target = "categoryName")
    TutorialByAuthorDto tutorialToTutorialByAuthorDto(Tutorial tutorial);

}


package com.bezkoder.spring.jpa.h2.mappers;

import com.bezkoder.spring.jpa.h2.dto.UserDto;
import com.bezkoder.spring.jpa.h2.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UserMapper {
    UserDto userToUserDto(Users user);

    Users userDtoToUsers(UserDto userDto);
}


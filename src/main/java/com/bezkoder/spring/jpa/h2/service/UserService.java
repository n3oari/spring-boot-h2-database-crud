package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.dto.UserDto;
import com.bezkoder.spring.jpa.h2.mappers.UserMapper;
import com.bezkoder.spring.jpa.h2.model.Users;
import com.bezkoder.spring.jpa.h2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public List<UserDto> getUsers(String name) {
        List<Users> users = (name == null || name.isEmpty())
                ? userRepository.findAll()
                : userRepository.findByFullNameContainingIgnoreCase(name); //

        return users.stream()
                .map(userMapper::userToUserDto)
                .toList();
    }
}

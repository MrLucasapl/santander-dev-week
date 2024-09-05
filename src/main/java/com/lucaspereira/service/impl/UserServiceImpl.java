package com.lucaspereira.service.impl;

import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import com.lucaspereira.domain.model.User;
import com.lucaspereira.repository.UserRepository;
import com.lucaspereira.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() != null &&
                userRepository.existsById(userToCreate.getId()) &&
                userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("this User Id already exists");
        }

        return userRepository.save(userToCreate);
    }

}

package com.lucaspereira.service;

import com.lucaspereira.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}

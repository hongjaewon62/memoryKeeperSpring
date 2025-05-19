package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.UserResponse;
import com.memorykeeper.memoryKeeperSpring.entity.User;

import java.util.Optional;

public interface UserService {
    UserResponse signUpUser(UserResponse userResponse) throws Exception;
    UserResponse loginUser(String username, String password) throws Exception;
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);
}

package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.UserResponse;
import com.memorykeeper.memoryKeeperSpring.entity.User;
import com.memorykeeper.memoryKeeperSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse signUpUser(UserResponse userResponse) throws  Exception {

        if (userResponse.getUsername() == null || userResponse.getUsername().trim().isEmpty()) {
            throw new Exception("아이디를 입력해주세요.");
        }

        if (userResponse.getPassword() == null || userResponse.getPassword().trim().isEmpty()) {
            throw new Exception("비밀번호를 입력해주세요.");
        }

        if (userResponse.getEmail() == null || userResponse.getEmail().trim().isEmpty()) {
            throw new Exception("이메일을 입력해주세요.");
        }

        if(userRepository.findByEmail(userResponse.getEmail()).isPresent()) {
            throw new Exception("이미 사용 중인 이메일입니다.");
        }

        if(userRepository.findByUsername(userResponse.getUsername()).isPresent()) {
            throw new Exception("이미 사용 중인 아이디입니다.");
        }

        userResponse.setPassword(passwordEncoder.encode(userResponse.getPassword()));

        User user = userResponse.toEntity();
        user = userRepository.save(user);

        return UserResponse.fromEntity(user);
    }

    @Override
    public UserResponse loginUser(String username, String password) throws Exception {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(username == null || username.trim().isEmpty()) {
            throw new Exception("아이디를 입력해주세요.");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new Exception("비밀번호를 입력해주세요.");
        }

        if (userOptional.isEmpty()) {
            throw new Exception("사용자를 찾을 수 없습니다.");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        return UserResponse.fromEntity(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

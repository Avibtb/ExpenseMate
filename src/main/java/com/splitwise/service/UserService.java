package com.splitwise.service;

import com.splitwise.dto.response.ApiResponse;
import com.splitwise.entity.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    Users createUser(Users users);

    ApiResponse<Object> getAllUsers();
    ApiResponse<Object> findUserById(String id);

    UserDetails findByEmail(String username);
    Users findByVerificationCode(String verificationCode);
}

package com.splitwise.service.impl;

import com.splitwise.dto.response.ApiResponse;
import com.splitwise.entity.Users;
import com.splitwise.exception.UserNotFoundException;
import com.splitwise.mapper.CustomMapper;
import com.splitwise.repository.UsersRepository;
import com.splitwise.service.UserService;
import org.apache.logging.log4j.util.InternalException;
import org.hibernate.boot.beanvalidation.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private CustomMapper customMapper;


    @Override
    public Users createUser(Users users) {
        Users savedUser;
        try {
            savedUser = usersRepository.save(users);
        }catch (Exception e){
            throw new IntegrationException("User is already exists with gmail "+ users.getEmail());

        }
        return savedUser;
    }

    @Override
    public ApiResponse<Object> getAllUsers() {
        List<Users> users;
        try{
            users = usersRepository.findAll();

        }catch (Exception e){
            throw new InternalException("Internal Server Error");
        }
        if(users.isEmpty()){
            return ApiResponse.builder()
                    .success(true)
                    .message("No user found")
                    .build();
        }
        return ApiResponse.builder()
                .data(customMapper.mapToUserDto(users))
                .success(true)
                .message("All users")
                .build();
    }

    @Override
    public ApiResponse<Object> findUserById(String id) {
        Users users = usersRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return ApiResponse.builder()
                .data(users)
                .success(true)
                .message("User with id "+ users.getId())
                .build();
    }

    @Override
    public UserDetails findByEmail(String email) {
        return usersRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

    }

    @Override
    public Users findByVerificationCode(String verificationCode) {
        return usersRepository.findByVerificationCode(verificationCode).orElseThrow(UserNotFoundException::new);
    }
}

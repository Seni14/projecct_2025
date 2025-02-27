package com.softuni.project_2025.service;

import com.softuni.project_2025.Repository.UserRepository;
import com.softuni.project_2025.model.Dto.UserRegistrationDto;
import com.softuni.project_2025.model.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userservice {

    private final UserRepository userRepository;


    public Userservice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(UserRegistrationDto registerData) {
        Optional<UserEntity> existingUser = userRepository.
                findByUsernameOrEmail(registerData.getUsername(), registerData.getEmail());
        if(existingUser.isPresent()){
            return false;
        }

        UserEntity userEntity=new UserEntity();

        userEntity.setUsername(registerData.getUsername());
        userEntity.setEmail(registerData.getEmail());
        userEntity.setPassword("");

        return true;
    }
}

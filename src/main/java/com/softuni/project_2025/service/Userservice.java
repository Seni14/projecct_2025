package com.softuni.project_2025.service;

import com.softuni.project_2025.Repository.UserRepository;
import com.softuni.project_2025.config.UserSession;
import com.softuni.project_2025.model.Dto.UserLoginDto;
import com.softuni.project_2025.model.Dto.UserRegistrationDto;
import com.softuni.project_2025.model.Entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userservice {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserSession userSession;


    public Userservice(UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
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
        userEntity.setPassword(passwordEncoder.encode(registerData.getPassword()));
        userRepository.save(userEntity);

        return true;
    }

    public boolean login(UserLoginDto loginData) {
        Optional<UserEntity> byUsername=userRepository.findByUsername(loginData.getUsername());
        if(byUsername.isEmpty()){
            return false;
        }
        boolean pMatch = passwordEncoder.matches(loginData.getPassword(), byUsername.get().getPassword());
        if(!pMatch){
            return false;
        }

        userSession.login(byUsername.get().getId(), loginData.getUsername());

        return true;
    }
}

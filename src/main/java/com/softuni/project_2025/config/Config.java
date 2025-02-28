package com.softuni.project_2025.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Config {
      @Bean
      public PasswordEncoder endocer(){
    return new BCryptPasswordEncoder();
  }
}

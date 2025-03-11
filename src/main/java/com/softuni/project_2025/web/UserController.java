package com.softuni.project_2025.web;

import com.softuni.project_2025.model.Dto.UserLoginDto;
import com.softuni.project_2025.model.Dto.UserRegistrationDto;
import com.softuni.project_2025.model.Entity.UserEntity;
import com.softuni.project_2025.service.Userservice;
import jakarta.persistence.PostRemove;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {


    private Userservice userservice;

    public UserController(Userservice userservice) {
        this.userservice = userservice;
    }

    @ModelAttribute("registerData")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }
    @ModelAttribute("loginData")
    public UserLoginDto userLoginDto(){
        return new UserLoginDto();
    }
    @GetMapping("/register")
    public String register(){return "register";}

    @PostMapping("/register")
    public String doRegister(
            @Valid UserRegistrationDto registerData,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
            ){
        if(bindingResult.hasErrors()|| !registerData.getPassword().equals(registerData.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("registerData",registerData);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData",bindingResult);
            return"redirect:/register";

        }
        boolean success = userservice.register(registerData);

        if(!success){
            return "redirect:/register";
        }

        return "redirect:/login";

    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String doLogin(
            @Valid UserLoginDto loginData,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes

    ){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("loginData",loginData);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData",bindingResult);
            return"redirect:/login";
        }

        boolean success = userservice.login(loginData);
        if(!success){
            redirectAttributes.addFlashAttribute("loginError",true);

            return "redirect:/login";
        }
        return "redirect:/home";
    }

}

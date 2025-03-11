package com.softuni.project_2025.web;

import com.softuni.project_2025.config.UserSession;
import com.softuni.project_2025.model.Dto.AddCarDto;
import com.softuni.project_2025.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarController {

    private CarService carService;
    private UserSession userSession;
    public CarController(CarService carService){
        this.carService=carService;
    }
    @ModelAttribute("carData")
    public AddCarDto addCarDto(){
        return new AddCarDto();
    }

    @GetMapping("/add-car")
    public String viewAddCar(){

        return "add-car";
    }
    @PostMapping("/add-car")
    public String doAddCar(
            @Valid AddCarDto data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("carData",data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.carData",bindingResult);
            return "redirect:/add-car";
        }

        boolean success = carService.create(data);
        if(!success){
            redirectAttributes.addFlashAttribute("carData",data);
            return"redirect:/add-car";
        }


        return "redirect:/home";
    }



}

package com.softuni.project_2025.service;

import com.softuni.project_2025.Repository.CarRepository;
import com.softuni.project_2025.Repository.UserRepository;
import com.softuni.project_2025.config.UserSession;
import com.softuni.project_2025.model.Dto.AddCarDto;
import com.softuni.project_2025.model.Entity.CarEntity;
import com.softuni.project_2025.model.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    private final UserSession userSession;

    public CarService(CarRepository carRepository, UserRepository userRepository, UserSession userSession) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean create(AddCarDto data) {

       if(!userSession.isLoggedIn()){
           return false;
       }

        Optional<UserEntity> byId = userRepository.findById(userSession.getId());
       if(byId.isEmpty()){
           return false;
       }

        CarEntity car=new CarEntity();
       car.setManufacturer(data.getManufacturer());
       car.setModel(data.getModel());
       car.setEngineType(data.getEngineType());
       car.setHorsePower(data.getHorsePower());
       car.setKilometers(data.getKilometers());
       car.setPrice(data.getPrice());
       car.setYear(data.getYear());
       car.setYear(data.getYear());
       car.setForSale(data.isForSale());
       car.setForRent(data.isForRent());
        carRepository.save(car);
        return true;
    }
}

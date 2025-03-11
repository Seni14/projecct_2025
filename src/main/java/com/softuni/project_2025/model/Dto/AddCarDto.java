package com.softuni.project_2025.model.Dto;

import com.softuni.project_2025.model.Enums.EngineType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddCarDto {
    @Min(50)
    @Max(1000)
    private int horsePower;
    @NotNull
    private String model;
    @NotNull
    private String manufacturer;

    private LocalDate year;
    @NotNull
    private EngineType engineType;
    @NotNull
    private BigDecimal price;
    @NotNull
    private int kilometers;

    private boolean forRent;

    private boolean forSale;

    private String image;

    public AddCarDto(){

    }

    public int getHorsePower() {
        return horsePower;
    }

    public AddCarDto setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public String getModel() {
        return model;
    }

    public AddCarDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public AddCarDto setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public LocalDate getYear() {
        return year;
    }

    public AddCarDto setYear(LocalDate year) {
        this.year = year;
        return this;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public AddCarDto setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddCarDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getKilometers() {
        return kilometers;
    }

    public AddCarDto setKilometers(int kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public boolean isForRent() {
        return forRent;
    }

    public AddCarDto setForRent(boolean forRent) {
        this.forRent = forRent;
        return this;
    }

    public boolean isForSale() {
        return forSale;
    }

    public AddCarDto setForSale(boolean forSale) {
        this.forSale = forSale;
        return this;
    }

    public String getImage() {
        return image;
    }

    public AddCarDto setImage(String image) {
        this.image = image;
        return this;
    }
}

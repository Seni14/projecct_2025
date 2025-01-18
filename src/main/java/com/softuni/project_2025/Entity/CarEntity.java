package com.softuni.project_2025.Entity;

import com.softuni.project_2025.Entity.Enums.EngineType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class CarEntity extends BaseEntity{
    private int horsePower;

    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String manufacturer;

    private LocalDate year;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    @Positive
    private BigDecimal price;
    @Positive
    private int kilometers;
    @Column(name = "for_rent")
    private boolean forRent;

    private boolean approved;
    @ManyToOne
    private UserEntity owner;

    public int getHorsePower() {
        return horsePower;
    }

    public CarEntity setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public CarEntity setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public LocalDate getYear() {
        return year;
    }

    public CarEntity setYear(LocalDate year) {
        this.year = year;
        return this;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public CarEntity setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CarEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getKilometers() {
        return kilometers;
    }

    public CarEntity setKilometers(int kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public boolean isForRent() {
        return forRent;
    }

    public CarEntity setForRent(boolean forRent) {
        this.forRent = forRent;
        return this;
    }

    public boolean isApproved() {
        return approved;
    }

    public CarEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public CarEntity setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }
}

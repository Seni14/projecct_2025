package com.softuni.project_2025.model.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "rents")
@Entity
public class RentsEntity extends BaseEntity{

    @ManyToOne
    private UserEntity renter;
    @ManyToOne
    private CarEntity car;
    @Column(name = "date_from")
    private LocalDate dateFrom;
    @Column(name = "date_to")
    private LocalDate dateTo;

    public UserEntity getRenter() {
        return renter;
    }

    public RentsEntity setRenter(UserEntity renter) {
        this.renter = renter;
        return this;
    }

    public CarEntity getCar() {
        return car;
    }

    public RentsEntity setCar(CarEntity car) {
        this.car = car;
        return this;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public RentsEntity setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public RentsEntity setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
        return this;
    }
}

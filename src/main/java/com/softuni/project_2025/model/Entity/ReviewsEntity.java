package com.softuni.project_2025.model.Entity;

import jakarta.persistence.*;

@Table(name = "reviews")
@Entity
public class ReviewsEntity extends BaseEntity{

    private int rating;

    private String comment;

    @ManyToOne
    private UserEntity reviewer;
    @ManyToOne
    private CarEntity car;
}

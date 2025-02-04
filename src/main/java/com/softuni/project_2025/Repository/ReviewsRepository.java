package com.softuni.project_2025.Repository;

import com.softuni.project_2025.model.Entity.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<ReviewsEntity,Long> {
}

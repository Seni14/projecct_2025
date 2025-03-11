package com.softuni.project_2025.Repository;

import com.softuni.project_2025.model.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity,Long> {
}

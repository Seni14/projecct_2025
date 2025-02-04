package com.softuni.project_2025.Repository;

import com.softuni.project_2025.model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}

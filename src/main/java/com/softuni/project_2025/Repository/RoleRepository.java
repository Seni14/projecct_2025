package com.softuni.project_2025.Repository;

import com.softuni.project_2025.model.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}

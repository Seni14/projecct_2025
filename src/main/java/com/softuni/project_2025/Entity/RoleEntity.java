package com.softuni.project_2025.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String role;

    public String getRole() {
        return role;
    }

    public RoleEntity setRole(String role) {
        this.role = role;
        return this;
    }
}

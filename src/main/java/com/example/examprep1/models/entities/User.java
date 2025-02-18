package com.example.examprep1.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @Column (unique = true, nullable = false)
    private String username;

    @Column (nullable = false)
    private String fullName;

    @Column (nullable = false)
    private String password;

    @Column (unique = true, nullable = false)
    private String email;
}

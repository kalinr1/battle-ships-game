package com.example.examprep1.models.models;

import com.example.examprep1.models.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends BaseEntity {

    private String username;

    private String fullName;

    private String password;

    private String email;
}

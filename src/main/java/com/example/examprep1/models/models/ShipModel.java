package com.example.examprep1.models.models;

import com.example.examprep1.models.entities.BaseEntity;
import com.example.examprep1.models.entities.Category;
import com.example.examprep1.models.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipModel extends BaseEntity {

    private String name;

    private Long health;

    private Long power;

    private LocalDate created;

    private CategoryModel category;

    private UserModel user;

    @Override
    public String toString() {
        return String.format("%s -- %s -- %s", this.name, this.health, this.power);
    }
}

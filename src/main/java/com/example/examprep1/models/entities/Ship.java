package com.example.examprep1.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "ships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ship extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column (nullable = false)
    private Long health;
    @Column (nullable = false)
    private Long power;

    @Column (nullable = false)
    private LocalDate created;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return String.format("%s -- %s -- %s", this.name, this.health, this.power);
    }
}

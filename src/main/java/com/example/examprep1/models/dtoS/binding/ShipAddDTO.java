package com.example.examprep1.models.dtoS.binding;

import com.example.examprep1.models.entities.Category;
import com.example.examprep1.models.entities.User;
import com.example.examprep1.models.enums.CategoryType;
import com.example.examprep1.models.models.CategoryModel;
import com.example.examprep1.validations.availableShipNameCheck.AvailableShipNameCheck;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipAddDTO {

    @Size (min = 2, max = 10)
    @AvailableShipNameCheck
    private String name;

    @Positive
    @NotNull
    private Long health;

    @Positive
    @NotNull
    private Long power;

    @PastOrPresent
    @NotNull
    private LocalDate created;

    @NotNull
    private CategoryType category;
}

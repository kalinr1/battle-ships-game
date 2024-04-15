package com.example.examprep1.models.models;

import com.example.examprep1.models.entities.BaseEntity;
import com.example.examprep1.models.enums.CategoryType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel extends BaseEntity {



    private CategoryType name;

    private String description;

}

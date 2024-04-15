package com.example.examprep1.models.entities;

import com.example.examprep1.models.enums.CategoryType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Enumerated (EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private CategoryType name;

    @Column (columnDefinition = "TEXT")
    private String description;

}

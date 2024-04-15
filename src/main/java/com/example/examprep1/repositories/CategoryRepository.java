package com.example.examprep1.repositories;

import com.example.examprep1.models.entities.Category;
import com.example.examprep1.models.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName (CategoryType name);
}

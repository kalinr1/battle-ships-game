package com.example.examprep1.repositories;

import com.example.examprep1.models.entities.Category;
import com.example.examprep1.models.entities.Ship;
import com.example.examprep1.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameAndPassword(String username, String password);
}


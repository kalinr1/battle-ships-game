package com.example.examprep1.repositories;

import com.example.examprep1.models.entities.Ship;
import com.example.examprep1.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);

    List<Ship> findAllByUser (User user);

    List<Ship> findAllByUserNot (User user);
}

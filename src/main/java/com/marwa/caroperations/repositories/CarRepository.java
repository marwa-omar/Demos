package com.marwa.caroperations.repositories;

import com.marwa.caroperations.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}

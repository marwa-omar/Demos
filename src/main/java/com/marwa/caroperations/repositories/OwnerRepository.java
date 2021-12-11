package com.marwa.caroperations.repositories;

import com.marwa.caroperations.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}

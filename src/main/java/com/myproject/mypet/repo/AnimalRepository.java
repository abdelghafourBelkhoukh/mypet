package com.myproject.mypet.repo;

import com.myproject.mypet.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Optional<Animal> findAnimalById(Long id);
}

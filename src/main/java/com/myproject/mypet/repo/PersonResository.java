package com.myproject.mypet.repo;

import com.myproject.mypet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonResository extends JpaRepository<Person, Long> {

    Optional<Person> findPersonById(Long id);
}

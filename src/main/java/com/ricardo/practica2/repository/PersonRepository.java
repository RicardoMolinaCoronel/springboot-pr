package com.ricardo.practica2.repository;

import com.ricardo.practica2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}

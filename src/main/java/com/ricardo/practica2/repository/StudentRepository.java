package com.ricardo.practica2.repository;

import com.ricardo.practica2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

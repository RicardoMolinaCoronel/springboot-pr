package com.ricardo.practica2.repository;

import com.ricardo.practica2.model.Employee;
import com.ricardo.practica2.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Page<Student> findByName(String name, Pageable pageable);

}

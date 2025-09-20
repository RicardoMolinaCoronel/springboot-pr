package com.ricardo.practica2.services;


import com.ricardo.practica2.model.Course;
import com.ricardo.practica2.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface StudentService {


    Set<Course> getAllCoursesByStudentId(Integer id);
    Page<Student> getAllStudentsByName(String name, Pageable pageable);

}

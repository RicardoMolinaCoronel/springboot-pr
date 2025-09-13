package com.ricardo.practica2.controllers;


import com.ricardo.practica2.model.Course;
import com.ricardo.practica2.repository.StudentRepository;
import com.ricardo.practica2.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/findAllCoursesByStudentId/{id}")
    public Set<Course> findAllCoursesByStudentId(@PathVariable Integer id){
        return studentService.getAllCoursesByStudentId(id);
    }


}

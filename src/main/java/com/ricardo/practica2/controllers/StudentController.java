package com.ricardo.practica2.controllers;


import com.ricardo.practica2.model.Course;
import com.ricardo.practica2.model.Student;
import com.ricardo.practica2.repository.StudentRepository;
import com.ricardo.practica2.services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findAllByName")
    public Page<Student>  findAllByName(@RequestParam String name,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size,
                                        @RequestParam(defaultValue = "name") String sortBy,
                                        @RequestParam(defaultValue = "asc") String sortOrder){
        Sort sort = sortOrder.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return studentService.getAllStudentsByName(name,pageable);


    }


}

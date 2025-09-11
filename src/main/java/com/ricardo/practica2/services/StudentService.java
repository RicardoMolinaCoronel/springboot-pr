package com.ricardo.practica2.services;


import com.ricardo.practica2.model.Course;

import java.util.Set;

public interface StudentService {


    Set<Course> getAllCoursesByStudentId(Integer id);

}

package com.ricardo.practica2.services;

import com.ricardo.practica2.model.Course;
import com.ricardo.practica2.model.Student;
import com.ricardo.practica2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Set<Course> getAllCoursesByStudentId(Integer id){

        Student student = studentRepository.findById(id).orElse(null);
        if (student != null){
            return student.getCourses();
        } else {
            return null;
        }
    }

    public Page<Student> getAllStudentsByName(String name, Pageable pageable) {
        return studentRepository.findByName(name,pageable);
    }


}

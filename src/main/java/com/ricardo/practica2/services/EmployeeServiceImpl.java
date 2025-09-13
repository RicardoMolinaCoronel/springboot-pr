package com.ricardo.practica2.services;

import com.ricardo.practica2.model.*;
import com.ricardo.practica2.repository.EmployeeRepository;
import com.ricardo.practica2.repository.PersonRepository;
import com.ricardo.practica2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private PersonRepository personRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PersonRepository personRepository, StudentRepository studentRepository) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Integer id, Employee employee){
            Employee currentEmployee = employeeRepository.findById(id).orElse(null);
            if(currentEmployee != null){
                currentEmployee.setName(employee.getName());
                currentEmployee.setEmail(employee.getEmail());
                currentEmployee.setHireDate(employee.getHireDate());
                return employeeRepository.save(currentEmployee);
            } else {
                return null;
            }
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }


    public List<Device> getAllDevicesById(Integer id){

        Person person = personRepository.findById(id).orElse(null);
        if (person != null){
            return person.getDevices();
        }else {
            return null;
        }

    }




}

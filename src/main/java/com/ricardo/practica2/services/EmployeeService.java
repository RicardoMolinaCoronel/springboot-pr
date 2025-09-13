package com.ricardo.practica2.services;

import com.ricardo.practica2.model.Course;
import com.ricardo.practica2.model.Device;
import com.ricardo.practica2.model.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {

    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);
    List<Employee> findEmployeesByName(String name);

    List<Device> getAllDevicesById(Integer id);


}

package com.ricardo.practica2.controllers;

import com.ricardo.practica2.exception.EmployeeNotFoundException;
import com.ricardo.practica2.exception.ErrorResponse;
import com.ricardo.practica2.model.Device;
import com.ricardo.practica2.model.Employee;
import com.ricardo.practica2.other.examples.ProductDao;
import com.ricardo.practica2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private ProductDao productDao;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ProductDao productDao) {
        this.employeeService = employeeService;
        this.productDao = productDao;
    }

    @GetMapping("/findById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/findAllProducts")
    public Collection findAllProducts(){
        return productDao.loadProductsByName("Vino");
    }


    @GetMapping("/findDevicesById/{id}")
    public List<Device> findDevicesById(@PathVariable Integer id){
        return employeeService.getAllDevicesById(id);
    }

    @GetMapping("/findByName")
    public List<Employee> findByName(@RequestParam("name") String name){
        return employeeService.findEmployeesByName(name);
    }


   @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse("EMPLOYEE_NOT_FOUND", ex.getMessage()), HttpStatus.NOT_FOUND);
    }





}

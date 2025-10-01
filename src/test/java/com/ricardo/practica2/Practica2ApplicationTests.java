package com.ricardo.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.ricardo.practica2.controllers.EmployeeController;
import com.ricardo.practica2.model.Employee;
import com.ricardo.practica2.other.examples.ProductDao;
import com.ricardo.practica2.repository.DeviceRepository;
import com.ricardo.practica2.repository.EmployeeRepository;
import com.ricardo.practica2.repository.PersonRepository;
import com.ricardo.practica2.repository.StudentRepository;
import com.ricardo.practica2.services.EmployeeService;
import com.ricardo.practica2.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
class Practica2ApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void testGetEmployeeById(){

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        PersonRepository personRepository = mock(PersonRepository.class);
        StudentRepository studentRepository = mock(StudentRepository.class);

        when(employeeRepository.findById(3)).thenReturn(Optional.of(new Employee(3, "Fausto", "fausto@gmail.com")));

        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, personRepository, studentRepository);
        Employee employee = employeeService.getEmployeeById(3);

        //assertEquals(3, employee.getId());
        assertEquals("Fausto", employee.getName());
        assertEquals("fausto@gmail.com", employee.getEmail());


    }

}

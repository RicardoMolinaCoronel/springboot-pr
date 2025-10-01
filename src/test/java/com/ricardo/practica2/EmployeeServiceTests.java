package com.ricardo.practica2;

import com.ricardo.practica2.model.Employee;
import com.ricardo.practica2.repository.EmployeeRepository;
import com.ricardo.practica2.services.EmployeeService;
import com.ricardo.practica2.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Test
    void getEmployeeById() {
        when(employeeRepository.findById(3)).thenReturn(Optional.of(new Employee(3, "Ricardo", "r@gmail.com")));

        Employee employee = employeeService.getEmployeeById(3);
        assertEquals(3, employee.getId());
        assertEquals("Ricardo", employee.getName());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 100})
    void getEmployeeByIdSequence(int id) {
        when(employeeRepository.findById(id)).thenReturn(Optional.of(new Employee(id, "Ricardo", "r@gmail.com")));

        Employee employee = employeeService.getEmployeeById(id);
        assertEquals(id, employee.getId());
    }
}

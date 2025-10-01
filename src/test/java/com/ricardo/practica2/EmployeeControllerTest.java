package com.ricardo.practica2;


import com.ricardo.practica2.controllers.EmployeeController;
import com.ricardo.practica2.model.Employee;
import com.ricardo.practica2.other.examples.ProductDao;
import com.ricardo.practica2.security.JwtUtils;
import com.ricardo.practica2.services.EmployeeService;
import com.ricardo.practica2.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private ProductDao productDao;

    @MockBean
    private JwtUtils jwtUtils;

    @Test
    void testGetEmployeeById() throws Exception {
        when(employeeService.getEmployeeById(3))
                .thenReturn(new Employee(3, "Ricardo", "r@gmail.com"));

        mockMvc.perform(get("/employees/findById/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ricardo"))
        ;

    }
}

package com.srinivas.assessment.service;

import com.srinivas.assessment.dto.EmployeeDTO;
import com.srinivas.assessment.model.Employee;
import com.srinivas.assessment.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testAddEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO(null, "Srinivas", 25, "Software Engineer", "Columbus");

        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);

        assertNotNull(savedEmployee);
        assertNotNull(savedEmployee.getId());
        assertEquals("Srinivas", savedEmployee.getName());
    }

    @Test
    public void testGetAllEmployees() {
        Employee emp1 = new Employee(1L,"Srinivas", 25, "Software Engineer", "Columbus");
        Employee emp2 = new Employee(2L, "Pravarsha", 23, "Data Engineer", "New York");
        employeeRepository.save(emp1);
        employeeRepository.save(emp2);

        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();

        assertFalse(employeeDTOList.isEmpty());
        assertEquals(2, employeeDTOList.size());
        assertEquals(emp1.getName(), employeeDTOList.get(0).getName());
        assertEquals(emp2.getName(), employeeDTOList.get(1).getName());
    }

}

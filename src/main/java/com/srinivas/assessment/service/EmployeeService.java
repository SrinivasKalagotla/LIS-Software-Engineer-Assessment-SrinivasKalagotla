package com.srinivas.assessment.service;

import com.srinivas.assessment.dto.EmployeeDTO;
import com.srinivas.assessment.model.Employee;
import com.srinivas.assessment.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Converts Employee Entity to DTO
    private EmployeeDTO convertToDTO(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setTitle(employee.getTitle());
        dto.setHometown(employee.getHometown());
        return dto;
    }

    //Converts Employee DTO to EmployeeEntity
    private Employee convertToEntity(EmployeeDTO dto){
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setTitle(dto.getTitle());
        employee.setHometown(dto.getHometown());
        return employee;
    }

    @Transactional
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return convertToDTO(savedEmployee);
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepository.findAll().stream()
                                    .map(this::convertToDTO)
                                    .collect(Collectors.toList());
    }
}

package com.srinivas.assessment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required and cannot be blank")
    private String name;

    private Integer age;

    @NotBlank(message = "Title is required and cannot be blank")
    private String title;

    private String hometown;

}

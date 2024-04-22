package com.srinivas.assessment;

import com.srinivas.assessment.dto.EmployeeDTO;
import com.srinivas.assessment.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "employeeForm";
    }

    @PostMapping("/employees")
    public String submitEmployeeForm(@Valid EmployeeDTO employeeDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "employeeForm";
        }
        employeeService.addEmployee(employeeDTO);
        redirectAttributes.addFlashAttribute("employee", employeeDTO);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    public String showConfirmation(Model model){
        if(!model.containsAttribute("employee")){
            return "redirect:/";
        }
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);
        return "confirmationPage";
    }
}

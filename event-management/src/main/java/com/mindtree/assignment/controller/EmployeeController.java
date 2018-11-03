package com.mindtree.assignment.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mindtree.assignment.model.Employee;
import com.mindtree.assignment.service.EmployeeEventMgmtService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeEventMgmtService employeeEventMgmtService;
	@GetMapping("/")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("employees", employeeEventMgmtService.list());
		return "AssignEvents";
	}
	
	@ModelAttribute("employee")
    public Employee formBackingObject() {
        return new Employee();
    }

	@PostMapping("/addEmployee")
	public String saveUser(@ModelAttribute("employee") @Valid Employee employee, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("users", employeeEventMgmtService.list());
			return "AssignEvents";
		}
		employeeEventMgmtService.save(employee);
		return "redirect:/";
	}
}

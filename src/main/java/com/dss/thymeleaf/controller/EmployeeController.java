package com.dss.thymeleaf.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.common.beans.beans.EmployeeRequest;
import com.api.common.beans.beans.EmployeeResponse;
import com.api.common.beans.beans.GroupResponse;
import com.api.common.beans.beans.SaldoResponse;
import com.dss.thymeleaf.service.EmployeeService;
import com.dss.thymeleaf.service.GeneralService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@Autowired
	private GeneralService generalService;
	
	@RequestMapping("/employee")
	public String viewHomePage(Model model) {
		List<EmployeeResponse> listEmployee = employeeService.listEmployee();
		model.addAttribute("listEmployees", listEmployee);
		return "employee/employee";
	}
	
	
	@GetMapping("/showNewEmployeeForm")
	 public String showNewEmployeeForm(Model model) {
	     // create model attribute to bind form data
		
	     EmployeeRequest employee = new EmployeeRequest();
	     
	     List<GroupResponse> listGroup = generalService.listGroups();
	     List<SaldoResponse> listSaldo = generalService.listSaldo();
	     
	     model.addAttribute("listSaldo",listSaldo);
	     model.addAttribute("listGroup",listGroup);
	     model.addAttribute("employee", employee);
	     return "employee/new_employee";
	 }
	
	@PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeRequest employee) throws ParseException {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }
}

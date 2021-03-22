package com.pack.ems.controller;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.ems.repository.EmployeeRepository;
import com.pack.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	EmployeeService service;

	/*
	 * 
	 * Handler to return index page
	 */
	@GetMapping("/sample")
	public String samplePAge() {
		return "local";
	}

	
	@GetMapping("/show")
	public String getIndexPage() {
		return "index";
	}

	
	// Handler to return addEmployee page

	@GetMapping("/addEmployee")
	public String addEmployeePage(Model model) {
		com.pack.ems.model.Employee employee = new com.pack.ems.model.Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";

	}

	// Handler to save an Employee to database

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute com.pack.ems.model.Employee employee, Model model) {
		com.pack.ems.entity.Employee emp = new com.pack.ems.entity.Employee();
		BeanUtils.copyProperties(employee, emp);
		Integer id = employee.getEmpno();
		boolean flag = repository.existsById(emp.getEmpno());
		if (flag == true) {
			model.addAttribute("message", "Sorry! Employee already exists!!!");
		} else {
			repository.save(emp);
			/*
			 * String s1="Record Successfully Added With id is :"+id;
			 * model.addAttribute("message1",s1 );
			 */
			model.addAttribute("message", "Employee added successfully with id  :" + id + " Do u Want Add More ? ");
		}

		return "index";

	}

	// Handler to return list of employees

	@GetMapping("/listEmployees")
	public String listEmployees(Model model) {
		Long time1 = System.currentTimeMillis();
		List<com.pack.ems.entity.Employee> empList = repository.findAll();
		Long time2 = System.currentTimeMillis();
		System.out.println("Time taken to list employess :" + (time2 - time1));
		model.addAttribute("employees", empList);
		return "employeesList";

	}

	// Handler to delete an employee

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("empno") Integer empno, Model model) {

		repository.deleteById(empno);
		  List<com.pack.ems.entity.Employee>
		  empList=repository.findAll();
		  model.addAttribute("employees", empList);
		  return "employeesList";
		  
		  }
	
	// Handler return editEmployee page

	@GetMapping("/editEmployee")
	public String getEditEmployeePage(@RequestParam("empno") Integer empno, Model model) {
		Optional<com.pack.ems.entity.Employee> opt = repository.findById(empno);
		com.pack.ems.entity.Employee employee = opt.get();
		com.pack.ems.model.Employee modelEmployee = new com.pack.ems.model.Employee();
		BeanUtils.copyProperties(employee, modelEmployee);
		model.addAttribute("employee", modelEmployee);
		return "editEmployee";
	}

	/*
	 * Handler to update employee in Database
	 */
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute("employee") com.pack.ems.model.Employee modelEmployee, Model model) {
		com.pack.ems.entity.Employee entityEmployee = new com.pack.ems.entity.Employee();
		BeanUtils.copyProperties(modelEmployee, entityEmployee);
		repository.saveAndFlush(entityEmployee);

		/*
		 * List<com.pack.ems.entity.Employee> empList=repository.findAll();
		 * model.addAttribute("employees", empList); return "employeesList";
		 */
		return "redirect:listEmployees";
	}

	/*
	 * Handler for search operation
	 */

	@GetMapping("/search")
	public String searchEmployeesByDept(@RequestParam("deptno") Integer deptNo, Model model) {
		if (deptNo == null) {
			model.addAttribute("noData", "sorry ! your Dept No not exists in database");
			return "redirect:employeeList";
		}

		List<com.pack.ems.entity.Employee> empList = repository.findByDeptNo(deptNo);
		/*
		 * com.pack.ems.entity.Employee entityEmployee=new
		 * com.pack.ems.entity.Employee();
		 * 
		 * Integer deptNumber= entityEmployee.getEmpno();
		 * 
		 */

		model.addAttribute("employees", empList);
		model.addAttribute("noData", "Ur DeptNo is :" + deptNo);

		return "employeesList";
	}
}

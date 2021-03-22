package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmpService {
	public Integer saveEmp(Employee e);
	public void deleteEmp(Integer id);
	List<Employee> getAllEmps();
	Employee getOneEmp(Integer id);
	Employee modifyEmp(Integer id);
	

}

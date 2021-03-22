package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repo.IEmpRepository;
@Service
public class EmpServiceImpl implements IEmpService{
	@Autowired
	private IEmpRepository repo;

	@Override
	public Integer saveEmp(Employee e) {
		return null;
	}

	@Override
	public void deleteEmp(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAllEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getOneEmp(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee modifyEmp(Integer id) {
		return null;
		
	}

	
}

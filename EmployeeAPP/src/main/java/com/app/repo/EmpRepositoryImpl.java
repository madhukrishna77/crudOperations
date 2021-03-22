package com.app.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

@Repository
public class EmpRepositoryImpl implements IEmpRepository{
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveEmp(Employee e) {
		
		return (Integer)ht.save(e);
	}

	public void deleteEmp(Integer id) {
		Employee e= new Employee();
		e.setEmpId(id);
		ht.delete(id);
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return ht.loadAll(Employee.class);
	}

	@Override
	public Employee getOneEmp(Integer id) {
		return ht.get(Employee.class, id);
	}

	@Override
	public Employee modifyEmp(Integer id) {
		Employee e= new Employee();
		ht.update(e);
		return e;
	}

	
}

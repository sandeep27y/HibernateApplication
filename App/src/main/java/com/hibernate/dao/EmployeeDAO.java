package com.hibernate.dao;

import com.hibernate.entity.Employee;

public interface EmployeeDAO {

	Employee createStudent(Employee employee);
	void deleteEmployee(Long employeeNo);
	Employee updateStudent(Employee employee);
	Employee findStudent(Long employeeNo);
	public Employee viewRecordByCritetia();
	public Employee viewRecordByHQL();
	
}

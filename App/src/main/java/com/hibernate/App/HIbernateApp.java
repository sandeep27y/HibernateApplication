package com.hibernate.App;

import java.util.Arrays;
import java.util.HashSet;

import com.hibernate.dao.EmployeeDAO;
import com.hibernate.dao.EmployeeDAOImpl;
import com.hibernate.entity.Address;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Salary;
import com.hibernate.utill.HibernateUtils;

public class HIbernateApp {

	public static void main(String[] args) {
		HibernateUtils.getSessionFactory();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee newemployee = new Employee("Ram", "M", "abc");
		Salary newsalary=new Salary(12000.00);
		newsalary.setEmployee(newemployee);
		newemployee.setSalary(newsalary);
		Address address1 = new Address("1452", "Fairborn", "OH", "USA");
		Address address2 = new Address("1501", "Irving", "TX", "USA");
		address1.setEmployee(newemployee);
		address2.setEmployee(newemployee);
		newemployee.setAddress(new HashSet(Arrays.asList(address1, address2)));
		employeeDAO.createStudent(newemployee);		
		//employeeDAO.findStudent(new Long(10000));		
			
		System.out.println("First Name: "+employeeDAO.viewRecordByHQL().getEmployeeId()+" Last Name: "+employeeDAO.viewRecordByHQL().getFirstName());
		employeeDAO.viewRecordByCritetia();		
	}
}

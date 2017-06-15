package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="salary")
public class Salary implements Serializable{
	
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(generator = "gen") 
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
	private Long employeeId;
	
	
	private Double salary;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;

	
	public Salary() {
		super();
	}


	public Salary(Double salary) {
		super();
		this.salary = salary;
	}

	

	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	
}

package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="address")
public class Address implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="address_id")
	private Long addressId;
	
	@Column(name = "address")
	private String address;

	@Column(name = "city", length=30)
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Address(String address, String city, String state, String country) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}



	public Long getAddressId() {
		return addressId;
	}



	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}



	public Address() {
		super();
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}

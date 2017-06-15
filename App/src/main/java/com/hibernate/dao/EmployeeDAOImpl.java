package com.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hibernate.entity.Employee;
import com.hibernate.utill.HibernateUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	public Employee createStudent(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.save(employee);
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
		}finally{
			session.close();
		}
		return null;
	}

	public void deleteEmployee(Long employeeNo) {
		// TODO Auto-generated method stub

	}

	public Employee updateStudent(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findStudent(Long employeeNo) {
		System.out.println("testing: "+employeeNo);
		Session session = sessionFactory.openSession();
		
		return null;
	}
	public Employee viewRecordByCritetia(){
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Employee.class,"employee");
			criteria.createAlias("employee.salary", "salary");
			criteria.createAlias("employee.address", "address");
			criteria.add(Restrictions.eq("salary.salary", new Double(12000.00)));
			criteria.add(Restrictions.eq("address.address", new String("1501")));
			Employee employee = (Employee) criteria.uniqueResult();
			if (employee != null) {
				System.out.println("employee Salary with 12000 and with address 1501 is: "+employee.getSalary().getSalary());
				return employee;
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
		return null;
	}
	
	
	public Employee viewRecordByHQL() {
		Session session = sessionFactory.openSession();
		try{
			Transaction t = session.beginTransaction();
			Query query = session.createQuery("from Employee where salary.salary>10000");//
			Employee employee = (Employee) query.uniqueResult();
			t.commit();
			return employee;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}

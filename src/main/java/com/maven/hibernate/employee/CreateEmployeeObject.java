package com.maven.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.employee.entity.Employee;


public class CreateEmployeeObject {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			Employee theEmployee1 = new Employee("Santhosh","Selvaraj","NTT Data Services");
			Employee theEmployee2 = new Employee("Pavani","Kallempudi","Qualcomm");
			Employee theEmployee3 = new Employee("Sushma","Kpneru","TCS");
			
			session.beginTransaction();
			
			session.save(theEmployee1);
			session.save(theEmployee2);
			session.save(theEmployee3);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}

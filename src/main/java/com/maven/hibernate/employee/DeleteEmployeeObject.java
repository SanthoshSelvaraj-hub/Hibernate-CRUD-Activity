package com.maven.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.employee.entity.Employee;


public class DeleteEmployeeObject {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int myId =5;
			
			session.beginTransaction();
			
			Employee myEmployee = session.get(Employee.class, myId);
			
			session.delete(myEmployee);
					
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}

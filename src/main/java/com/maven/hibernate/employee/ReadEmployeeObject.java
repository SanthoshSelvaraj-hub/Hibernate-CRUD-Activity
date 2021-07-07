package com.maven.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.employee.entity.Employee;


public class ReadEmployeeObject {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			Employee theEmployee1 = new Employee("Sumanth","Nacharam","Qualcomm");
			
			session.beginTransaction();
			
			session.save(theEmployee1);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee myEmployee = session.get(Employee.class, theEmployee1.getId());
			
			System.out.println(myEmployee+ " "+ theEmployee1.getId());
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}

package com.maven.hibernate.employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.employee.entity.Employee;


public class QueryEmployeeObject {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			displayEmployees(theEmployees);
			
			theEmployees = session.createQuery("from Employee s where s.lastName='Kpneru'").getResultList();
			
			//display the students
			System.out.println("Students with last name Koneru");
			displayEmployees(theEmployees);
			
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for(Employee tempEmployee: theEmployees)
			System.out.println(tempEmployee);
	}

}

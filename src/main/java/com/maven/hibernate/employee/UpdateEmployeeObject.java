package com.maven.hibernate.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.maven.hibernate.employee.entity.Employee;


public class UpdateEmployeeObject {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int myId =3;
			
			session.beginTransaction();
			
			Employee myEmployee = session.get(Employee.class, myId);
			
			myEmployee.setFirstName("Sushma");
					
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Employee set lastName='Choudary' where firstName = 'Sushma'").executeUpdate();
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}

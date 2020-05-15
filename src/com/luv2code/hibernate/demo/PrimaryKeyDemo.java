package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create 3 student objects
			System.out.println("Creating 3 Student objects...");
			Student tempStudent1 = new Student("Abdelali", "Banaiche", "banaiche.abdelali@gmail.com");
			Student tempStudent2 = new Student("Amine", "Ghazil", "ghazil.amine@gmail.com");
			Student tempStudent3 = new Student("Ayoub", "Abouhilal", "abouhilal.ayoub@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}

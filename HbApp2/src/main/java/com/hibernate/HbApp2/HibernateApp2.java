package com.hibernate.HbApp2;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.HbApp2.entity.Student;

public class HibernateApp2 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration().configure()
    							.addAnnotatedClass(Student.class);
    	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
    			.applySettings(configuration.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
    	Session session=sessionFactory.openSession();
    	
    	Student student = new Student();
    	student.setEmail("srisad95@gmail.com");
    	student.setFname("srikanth");
    	student.setSid(101);
    	student.setSname("yenagandula");
    	student.setPersentage(75);
    	
    	Transaction transaction = session.beginTransaction();
    	session.save(student);
    	transaction.commit();
    	
    }
}

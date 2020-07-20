package com.hibernate.HbApp4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.entity.Laptop;

public class HbApp4 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class);
    	
    	ServiceRegistry serviceRegistry  = new ServiceRegistryBuilder()
    																.applySettings(configuration.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
    	Session session=sessionFactory.openSession();
    	
    	session.beginTransaction();
    	
    	/*
    	Laptop laptop=new Laptop();
    	laptop.setBrand("Asus");
    	laptop.setPrice(50000);
    	
    	session.save(laptop);
    	
    	*/
    	
    	/*
    	 * using get()
    	 * it is every time hit the database to fetch record & give exact object(real object)
    	 * it gives null pointer exception if the record is does not exist
    	 * 
    	 */
    	/*Laptop laptop=(Laptop)session.get(Laptop.class, 0);
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println(laptop);
    	*/
    	
    	/*
    	 * using load()
    	 * it is every time not hit the database to fetch record & give proxy object
    	 * when you need that object values then only hit the database
    	 * it gives object not found exception if the record is does not exist
    	 * 
    	 */
    	Laptop laptop2=(Laptop)session.load(Laptop.class, 0);
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println("=====================");
    	System.out.println(laptop2);
    	
    	
    	
    	
    	session.getTransaction().commit();
    }
}

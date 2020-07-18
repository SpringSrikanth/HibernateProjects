package com.hibernate.hbapp.maprelations;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.hbapp.entity.Employee;
import com.hibernate.hbapp.entity.Laptop;

public class HibernateRelationOneToMany 
{
    public static void main( String[] args )
    {
    	//Create Laptop Object
    	Laptop laptop = new Laptop();
    	laptop.setCompanyName("Dell");
    	laptop.setLid(101);
    	laptop.setPrice(45255.00);
    	
    	//Create Employee Object
    	Employee employee  = new Employee();
    	employee.setCompanyName("Accenture");
    	employee.setEid(201);
    	employee.setEname("Y.BHARATH");
    	employee.setLaptop(laptop);
    	
    	
    	//Create Configuration object and configure cfg file
    	Configuration configuration= new Configuration().configure()
    														.addAnnotatedClass(Employee.class)
    														.addAnnotatedClass(Laptop.class);
    	//Create ServiceRegisty object
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
    															.applySettings(configuration.getProperties())
    															.buildServiceRegistry();
    	//Create SessionFactoryObject using Configuration and service Registry
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
    	//Create Sessions Using sessionFactoryObject
    	Session session = sessionFactory.openSession();
    	
    	//Create Transaction Object
    	Transaction transaction = session.beginTransaction();
    	
    	//doing crud operations inside transaction
    	session.save(laptop);
    	session.save(employee);
    	//closing transaction by using Commit();
    	transaction.commit();
    }
}

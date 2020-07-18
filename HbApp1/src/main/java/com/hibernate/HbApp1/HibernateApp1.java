package com.hibernate.HbApp1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.entity.Carector;
import com.hibernate.entity.DirectorDetails;

public class HibernateApp1 
{
    public static void main( String[] args )
    {
      //Creating carector

    	DirectorDetails directorDetails = new DirectorDetails();
    	directorDetails.setDirectorName("Chris Buck");
    	directorDetails.setScreenPlay("Jennifer Lee");
    	directorDetails.setCountry("usa");
    	
    	Carector carector= new Carector();
    	carector.setCharectorId(102);
    	carector.setCharectorName("Aana");
    	carector.setCharectorType("Animated/HumanBeing");
    	carector.setGender("Female");
    	carector.setMovieName("Frozen");
    	carector.setDirectorDetails(directorDetails);
    	
    	/*
    	//Creating carector2
    	Carector carector2= new Carector();
    	carector2.setCharectorId(102);
    	carector2.setCharectorName("Aana");
    	carector2.setCharectorType("Animated/HumanBeing");
    	carector2.setGender("Female");
    	carector2.setMovieName("Frozen");
    	
    	//Creating carector3
    	Carector carector3= new Carector();
    	carector3.setCharectorId(103);
    	carector3.setCharectorName("Simba");
    	carector3.setCharectorType("Animated/Animal");
    	carector3.setGender("Male");
    	carector3.setMovieName("The Lion King");
    	
    	//Creating carector4
    	Carector carector4= new Carector();
    	carector4.setCharectorId(104);
    	carector4.setCharectorName("Nala");
    	carector4.setCharectorType("Animated/Animal");
    	carector4.setGender("Female");
    	carector4.setMovieName("The Lion King");
    	*/
    	
    	Carector carectorDeatails = null;
    	
    	Configuration configuration= new Configuration().configure()
    			.addAnnotatedClass(Carector.class);
    	/*@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session =sessionFactory.openSession();
		*It is deprecated from earlier version so we use ServiceRegistry for alternative
		*/
    	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
    																.applySettings(configuration.getProperties())
    																.buildServiceRegistry();
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
    	Session session =sessionFactory.openSession();
    	
    	Transaction transaction = session.beginTransaction();
//    	session.save(carector);
    	
    	//session.save(carector2);
    	carectorDeatails=(Carector) session.get(Carector.class, 102);
    //
    	transaction.commit();

        System.out.println("===========Charector Details of 102==============");
    	System.out.println(carectorDeatails);
    	/*
    	System.out.println("===========Charector 1 Details==============");
    	System.out.println(carector);
    	System.out.println("===========Charector 2 Details==============");
    	System.out.println(carector2);
    	System.out.println("===========Charector 3 Details==============");
    	System.out.println(carector3);
    	System.out.println("===========Charector 4 Details==============");
    	System.out.println(carector4);*/
    }
}

package com.hibernate.hb.caching;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateCaching 
{
    public static void main( String[] args )
    {
    	   Alian alian=new Alian();
      Configuration configuration = new Configuration().configure().addAnnotatedClass(Alian.class);
      
      ServiceRegistry  serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
      
      SessionFactory sessionFactory =  configuration.buildSessionFactory(serviceRegistry);
      
      Session session = sessionFactory.openSession();
      
      session.beginTransaction();
      
      /*Alian alian = new Alian(101,"Aana","red","ana");
      
      session.save(alian);*/
      
      /* Checking firstlevel cache*/
      /****************  Using get()   ****************/
     /* alian=(Alian) session.get(Alian.class, 1);*/
      
      /****************  Using Query  ****************/
      Query query =  session.createQuery("from Alian where alianId=1");
      query.setCacheable(true);
      alian=(Alian) query.uniqueResult();
      System.out.println(alian);
      
      /*alian=(Alian) session.get(Alian.class, 1);
      System.out.println(alian);*/
      
      session.getTransaction().commit();
      session.close();
      
      Session session2 = sessionFactory.openSession();
      session2.beginTransaction();
      /****************  Using get()   ****************/
      /*  alian=(Alian) session2.get(Alian.class, 1);*/
      
      /****************  Using Query  ****************/
      Query query2 =  session2.createQuery("from Alian where alianId=1");
      query2.setCacheable(true);
      alian=(Alian) query2.uniqueResult();
      System.out.println(alian);
      session2.getTransaction().commit();
      
    }
}

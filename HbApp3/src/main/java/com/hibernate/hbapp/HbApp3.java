package com.hibernate.hbapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.entity.Laptop;

public class HbApp3 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class);
        
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Session session=sessionFactory.openSession();
        
        session.beginTransaction();
        
        Laptop laptop = new Laptop();
        laptop.setBrand("Acer Swift 3");      //initially this laptop entity is there in transient state
        laptop.setPrice(54505.00);
        
        session.save(laptop); 
        /*
         * we can save laptop by using save() /persist() method 
         * later the laptop entity is avaliable for any modifications 
         * if you do any modifications  inside laptop properties it will be change.
         * if session destroy or outside transaction the object is not suitable for 
         * changing .and call detach(entityObj) it will go detached state.
         * 
         */
        laptop.setBrand("Asus NoteBook2"); 
        /* 
         * Actually i need to change the value of the object after save 
         * 'Cause i want to check entity object is there in persist state or not.
         */ 
        session.getTransaction().commit();
        
        laptop.setBrand("Asus NoteBook1"); 
        /* 
         * if you want to remove object from database it will goto removed state.
         */
    }
}

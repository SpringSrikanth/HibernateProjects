package com.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAApp 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory  emf = Persistence.createEntityManagerFactory("pu");
    	
    	
        EntityManager entityManager=emf.createEntityManager();
        
        Laptop laptop=entityManager.find(Laptop.class, 0);
        
        System.out.println(laptop);
        
        

    }
}

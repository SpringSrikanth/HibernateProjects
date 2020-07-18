package com.hibernate.onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateOneToManyRelationship
{
    public static void main( String[] args )
    {

    	Person person = new Person();
    	person.setPid(102);
    	person.setfName("Bharath Kumar");
    	person.setlName( "Yenagandula");
    	person.setpAge(28);
    	person.setPemail("kumarbharath64@gmail.com");
    	
    	Address address = new Address();
    	address.setAid(204);
    	address.setCity("Sircilla");
    	address.setHno("8-5-112");
    	address.setPincode(505301);
    	address.setStreetName("Nehrunagar");
    	address.setState("Telangana");
    	address.setPerson(person);
    	
    	Address address2 = new Address();
    	address2.setAid(205);
    	address2.setCity("Mandepally");
    	address2.setHno("2-16");
    	address2.setPincode(505401);
    	address2.setStreetName("Mandepally");
    	address2.setState("Telangana");
    	address2.setPerson(person);
    	
    	Address address3 = new Address();
    	address3.setAid(206);
    	address3.setCity("Hyderabad");
    	address3.setHno("N/A");
    	address3.setPincode(500072);
    	address3.setStreetName("Bio Diversity");
    	address3.setState("Telangana");
    	address3.setPerson(person);
    	
    	
    	List<Address> addresses=person.getAddresses();
    	addresses.add(address);
    	addresses.add(address2);
    	addresses.add(address3);
    	person.setAddresses(addresses);
    	
    	
    	Configuration configuration  = new Configuration().configure()
    													.addAnnotatedClass(Person.class)
    													.addAnnotatedClass(Address.class);
    	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
    			.applySettings(configuration.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
    	Session session = sessionFactory.openSession();
    	
    	Transaction transaction = session.beginTransaction();
    	
    	session.save(address);
    	session.save(address2);
    	session.save(address3);
    	
    	session.save(person);
    	
    	transaction.commit();
    }
}

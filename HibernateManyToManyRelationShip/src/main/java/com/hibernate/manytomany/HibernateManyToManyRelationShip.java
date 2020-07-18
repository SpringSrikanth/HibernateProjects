package com.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.entity.Employee;
import com.hibernate.entity.PcSystem;

public class HibernateManyToManyRelationShip 
{
    public static void main( String[] args )
    {
    	Employee employee = new Employee();
    	employee.setEid(201);
    	employee.setEname("Srikanth Y");
    	employee.setEsal(45000);
    	
    	Employee employee2 = new Employee();
    	employee2.setEid(202);
    	employee2.setEname("Bharath Y");
    	employee2.setEsal(75000);
    	
    	PcSystem pcSystem = new PcSystem();
    	pcSystem.setPcId(101);
    	pcSystem.setOsName("window 7");
    	pcSystem.setPrice(45200);
    	pcSystem.setRam("8 GB");
    	pcSystem.setRom("500 GB");
    	
    	PcSystem pcSystem2 = new PcSystem();
    	pcSystem2.setPcId(102);
    	pcSystem2.setOsName("window 8");
    	pcSystem2.setPrice(52000);
    	pcSystem2.setRam("16 GB");
    	pcSystem2.setRom("1024 GB");
    	
    	PcSystem pcSystem3 = new PcSystem();
    	pcSystem3.setPcId(103);
    	pcSystem3.setPrice(65200);
    	pcSystem3.setOsName("window 10");
    	pcSystem3.setRam("16 GB");
    	pcSystem3.setRom("2048 GB");
    	
    	List<PcSystem> pcSystems = new ArrayList<PcSystem>();
    	pcSystems.add(pcSystem);
    	pcSystems.add(pcSystem2);
    	pcSystems.add(pcSystem3);
    	
    	List<Employee> employees = new ArrayList<Employee>();
    	employees.add(employee);
    	employees.add(employee2);
    	
    	employee.setPcSystems(pcSystems);
    	employee2.setPcSystems(pcSystems);
    	
    	pcSystem.setEmployees(employees);
    	pcSystem2.setEmployees(employees);
    	pcSystem3.setEmployees(employees);
    	
    	Configuration configuration = new Configuration().configure()
    													.addAnnotatedClass(PcSystem.class)
    													.addAnnotatedClass(Employee.class);
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
    			.applySettings(configuration.getProperties()).buildServiceRegistry();
    	
    	SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    
    	Session session=sessionFactory.openSession();
    	
    	Transaction transaction = session.beginTransaction();
    	
    	session.save(employee);
    	session.save(employee2);
    	
    	session.save(pcSystem);
    	session.save(pcSystem3);
    	session.save(pcSystem2);

    	
    	transaction.commit();
    }
}

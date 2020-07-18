package com.hibernate.hb.hql;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateHQL 
{
    public static void main( String[] args )
    {
    	Random random =  new Random();
    	
       Configuration configuration = new Configuration().configure()
    		   	.addAnnotatedClass(Student.class)
    		   ;
       
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
       
       SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       
       Session session=sessionFactory.openSession();
       
       Transaction transaction = session.beginTransaction();
       
       /*for (int i = 0; i < 55; i++) {
    	   Student student = new Student();
    	   student.setSname("Name-"+i);
    	   int value1=(random.nextInt(100)/10)*10;
    	   value1=value1<40?35:value1;
    	   student.setPer(""+value1);
    	   session.save(student);
       }*/
       /*Query query = session.createQuery("from Student");
       List<Student> list=query.list();
       System.out.println("===============Student Details================");
       for (Student student : list) {
    	   System.out.println(student);
	   }
       
       Query query2= session.createQuery("from Student where sid=1");
       Student student2= (Student)query2.uniqueResult();
       System.out.println(student2);
       Query query3 = session.createQuery("from Student where per>=50 order by per desc");
       List<Student> list2=query3.list();
       System.out.println("========Student Details Greater than Per 50%========");
       for (Student student : list2) {
    	   System.out.println(student);
	   }*/
       
       //using properties
       /*Query query3 = session.createQuery("select sid,sname,per from Student");
       List<Object[]> students=query3.list();
       for (Object[] student:students) {
    	   System.out.println(student[0]+":"+student[1]+":"+student[2]);
       }
       
       System.out.println("========Student Details Greater than Per 50%========");
       Query query4 = session.createQuery("select sid,sname,per from Student where per>50");
       List<Object[]> students2=query4.list();
       for (Object[] student:students2) {
    	   System.out.println(student[0]+":"+student[1]+":"+student[2]);
       }
       
       Query query5 = session.createQuery("select sid,sname,per from Student where sid=1");
       Object[] student4=(Object[])query5.uniqueResult();
       System.out.println(student4[0]+":"+student4[1]+":"+student4[2]);
       
       Query query6 = session.createQuery("select sum(sid) from Student");
       Long sumOfPer = (Long)query6.uniqueResult();
       System.out.println(sumOfPer);*/
       
       //using queryStrings/Positional Parameters
       String perc=""+50;
       Query query7 =session.createQuery("select s.sid,s.sname,s.per from Student s where s.per> :perc ");
       query7.setParameter("perc",perc);
       
       List<Object[]> students = query7.list();
       for (Object[] objects : students) {
		System.out.println(objects[0]+"::"+objects[1]+"::"+objects[2]);
       }
       
       transaction.commit();
    }
}

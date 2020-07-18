package com.Hibernate.HibernateNativeSQL;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.Hibernate.entity.Student;

public class HibernateNativeSql 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        
        ServiceRegistry serviceRegistry =  new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        /*
        for (int i = 0; i < 50; i++) {
			Student student = new Student();
			student.setSname("Name~"+ i);
			student.setPer(new Random().nextInt(100));
			session.save(student);
		}
        */
        /*SQLQuery sqlQuery = session.createSQLQuery("select * from students where per>50");
        sqlQuery.addEntity(Student.class);
        List<Student> students=sqlQuery.list();
        for (Student student :students) {
        	System.out.println(student);
		}*/
        
        SQLQuery sqlQuery = session.createSQLQuery("select sid,sname from students");
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students=sqlQuery.list();
        for (Object s: students) {
        	Map map = (Map)s;
			System.out.println(map.get("sid")+":"+map.get("sname"));
		}
        
        session.getTransaction().commit();
    }
}

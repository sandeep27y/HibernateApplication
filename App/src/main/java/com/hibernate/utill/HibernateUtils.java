package com.hibernate.utill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	  
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    
    private static SessionFactory buildSessionFactory() {
		try {
	            Configuration configuration = new Configuration();
	            configuration.configure("hibernate.cfg.xml");
	            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
	            return sessionFactory;
		} catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static java.sql.Date dateParsingToSQL(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date utildate = null;
		try {
			utildate = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
		return sqldate;
		
	}
}

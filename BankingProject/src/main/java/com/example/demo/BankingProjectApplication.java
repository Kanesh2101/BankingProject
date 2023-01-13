package com.example.demo;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;

@SpringBootApplication
public class BankingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingProjectApplication.class, args);
	}

	public static SessionFactory buildSessionFactory(Class className, Class className2) {
		return new Configuration()
				.configure()
				.addAnnotatedClass(className)
				.addAnnotatedClass(className2)
				.buildSessionFactory();
	}
	
//	public static SessionFactory buildSessionFactory(Class className, Class className2) {
//		Configuration config = new Configuration()
//				.configure()
//				.addAnnotatedClass(className)
//				.addAnnotatedClass(className2);
//		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//	    return  config.buildSessionFactory(registry);
//
//	}
}

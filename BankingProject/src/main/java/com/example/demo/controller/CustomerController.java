package com.example.demo.controller;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BankingProjectApplication;
import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;


@Controller
public class CustomerController 
{
	
	SessionFactory sessionF = BankingProjectApplication.buildSessionFactory(Customer.class, Account.class);

	
	@RequestMapping("/")
	public String home() 
	{
		return "home.jsp";
	}

	
	

	@RequestMapping("/redirect")
	public String redirectSuccess() 
	{
		return "showCustomers.jsp";
	}
	

	@RequestMapping("/accountView")
	public String accountView() 
	{
		return "account.jsp";
	}
	
	@RequestMapping("/customerView")
	public String customerView() 
	{
		return "customer.jsp";
	}
	
	@RequestMapping("/createCustomerView")
	public String createCustomerView() 
	{
		return "createCustomerView.jsp";
	}
	
	@RequestMapping("/inquireCustomerView")
	public String inquireCustomerView() 
	{
		return "inquireCustomerView.jsp";
	}
	
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer(Customer customer) 
	{

		try {
		ModelAndView vw = new ModelAndView();
		Session session = sessionF.openSession();
	    Transaction transaction = session.beginTransaction();//start transaction
		session.persist(customer);
		session.flush();
	    transaction.commit();
	    session.close();

	    vw.addObject(customer);
    	vw.setViewName("showCustomer.jsp");	
    	return vw;
    	}
    	
		catch (Exception ex){
			
			ModelAndView vw = new ModelAndView("errorPage.jsp");
			return 	vw;
		}
	}
	
	@RequestMapping("/getCustomer")
	public ModelAndView getCustomer(@RequestParam String Name) 
	{
		try {
	    	ModelAndView vw = new ModelAndView();
			Session session = sessionF.openSession();
		    Transaction transaction = session.beginTransaction();//start transaction
	
		    String hql = "FROM Customer WHERE name=:name";
			Query query = session.createQuery(hql).setParameter("name", Name);
			
			 Customer customer = (Customer) query.uniqueResult();
			session.flush();
		    transaction.commit();
		    session.close();
		    if(customer != null) {
		    	vw.setViewName("showCustomer.jsp");
				vw.addObject(customer);
		    }else {
		    	vw.setViewName("notFound.jsp");
		    }
			
			return vw;
		}
		catch (Exception ex){
			
			ModelAndView vw = new ModelAndView("errorPage.jsp");
			return 	vw;
		}
	}
	
	@RequestMapping("/getCustomers/{name}")
	@ResponseBody
	public ResponseEntity<Customer> getCustomerJson(@PathVariable("name") String name) 
	{

		Session session = sessionF.openSession();
	    Transaction transaction = session.beginTransaction();//start transaction

	    String hql = "FROM Customer WHERE name=:name";
		Query query = session.createQuery(hql).setParameter("name", name);
		
		 Optional<Customer> customer = Optional.ofNullable((Customer) query.uniqueResult());

		 if(customer.isPresent()) {
		        return ResponseEntity.ok().body(customer.get());
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	
	@PostMapping("/addCustomers")
	@ResponseBody
	public ResponseEntity<Customer> addCustomers(@RequestBody Customer customer) 
	{

		Session session = sessionF.openSession();
	    Transaction transaction = session.beginTransaction();//start transaction
	    String hql = "FROM Customer WHERE name=:name";
		Query query = session.createQuery(hql).setParameter("name", customer.getName());
		
		 Optional<Customer> cust = Optional.ofNullable((Customer) query.uniqueResult());
		 if(cust.isEmpty()) {
			 session.persist(customer);
				session.flush();
			    transaction.commit();
			    session.close();
		 }else{
			 return new ResponseEntity<Customer>( 
				      HttpStatus.BAD_REQUEST);
		 }
		 System.out.println("test" + cust);
		

//		 if(customer.isPresent()) {
		return new ResponseEntity<Customer>( 
			      HttpStatus.OK);//		    } else {
//		        return ResponseEntity.notFound().build();
//		    }
	}
	
	
	
}

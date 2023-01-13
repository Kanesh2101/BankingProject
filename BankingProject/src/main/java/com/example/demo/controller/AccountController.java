package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BankingProjectApplication;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;

@Controller
public class AccountController {
	
	SessionFactory sessionF = BankingProjectApplication.buildSessionFactory(Customer.class,Account.class);


	@RequestMapping("/account")
	public String home() 
	{
		return "account.jsp";
	}
	
	@RequestMapping("/createAccountView")
	public String createAccountView() 
	{
		return "createAccountView.jsp";
	}
	
	@RequestMapping("/inquireAccountView")
	public String inquireAccountView() 
	{
		return "inquireAccountView.jsp";
	}
	
	@RequestMapping("/closeAccountView")
	public String closeAccountView() 
	{
		return "closeAccountView.jsp";
	}
	
	@RequestMapping("/depositAccountView")
	public String depositAccountView() 
	{
		return "depositAccountView.jsp";
	}
	
	@RequestMapping("/withdrawAccountView")
	public String withdrawAccountView() 
	{
		return "withdrawAccountView.jsp";
	}
	
	@RequestMapping("/backToHome")
	public String backToHome() 
	{
		return "home.jsp";
	}
	
	@RequestMapping("/createAccount")
	public ModelAndView addCustomer(@RequestParam String AccountName ,Account account) 
	{
		try {
			ModelAndView vw = new ModelAndView();
			Session session = sessionF.openSession();
		    Transaction transaction = session.beginTransaction();//start transaction
			Customer cust = new Customer();

			String hql = "FROM Customer WHERE name=:accountName";
			Query query = session.createQuery(hql).setParameter("accountName", AccountName);
			
			cust = (Customer) query.uniqueResult();
			if(cust != null) {
				System.out.println("customer" + cust.getName());

				account.setCustomer(cust);

				session.persist(account);

			    session.getTransaction().commit();
			    vw.addObject(account);
		    	vw.setViewName("showAccount.jsp");
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
	
	@RequestMapping("/inquireAccount")
	public ModelAndView inquireAccount(@RequestParam int AccountNumber) 
	{
		try {
		ModelAndView vw = new ModelAndView();
		Session session = sessionF.openSession();
	    Transaction transaction = session.beginTransaction();//start transaction
	    Account account= session.get(Account.class, AccountNumber);
		session.flush();
	    transaction.commit();
	    session.close();
	    
	    if(account != null) {
	    	vw.addObject(account);
	    	vw.setViewName("showAccount.jsp");
			
	    }else {
	    	vw.setViewName("notFound.jsp");
	    }
//		vw.addObject(account);
		return vw;
		}
		catch (Exception ex){
			
			ModelAndView vw = new ModelAndView("errorPage.jsp");
			return 	vw;
		}
		
		
	}
	
	@RequestMapping("/closeAccount")
	public ModelAndView closeAccount(@RequestParam int AccountNumber) 
	{
		try {
		ModelAndView vw = new ModelAndView();
		Session session = sessionF.openSession();
	    Transaction transaction = session.beginTransaction();//start transaction
	    Account account = session.get(Account.class, AccountNumber);
	    if(account != null) {
	    	account.setAccountStatus(0);
	 	    account.setAmmount(0);
	 	    session.persist(account);
	 		session.flush();
	 	    transaction.commit();
	 	    session.close();
			vw.addObject(account);
	    	vw.setViewName("showAccount.jsp");
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
	
	@RequestMapping("/depositCash")
	public ModelAndView depositCash(@RequestParam int AccountNumber, @RequestParam double Ammount) 
	{
		ModelAndView vw = new ModelAndView();
		Session session = sessionF.openSession();
	    Transaction transaction = session.beginTransaction();//start transaction
	    Account account = session.get(Account.class, AccountNumber);
	    if(account != null) {
	    	double currentBalance = account.getAmmount() + Ammount;
	  	    account.setAmmount(currentBalance);
	  	    session.persist(account);
	  		session.flush();
	  	    transaction.commit();
	  	    session.close();
	  		vw.addObject(account);
	    	vw.setViewName("showAccount.jsp");
	    }else {
	    	vw.setViewName("notFound.jsp");
	    }
		return vw;
	}
	
	@RequestMapping("/withdrawCash")
	public ModelAndView withdrawCash(@RequestParam int AccountNumber, @RequestParam double Ammount) 
	{
		try {
		ModelAndView vw = new ModelAndView("showCustomers.jsp");
		Session session = sessionF.openSession();
	    Transaction transaction = session.beginTransaction();//start transaction
	    Account account = session.get(Account.class, AccountNumber);
	    if(account != null && account.getAmmount()>Ammount ) {
	    	 double currentBalance = account.getAmmount() - Ammount;
	 	    account.setAmmount(currentBalance);
	 	    session.persist(account);
	 		session.flush();
	 	    transaction.commit();
	 	    session.close();
	 	    vw.addObject(account);
	    	vw.setViewName("showAccount.jsp");
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
	
	
	
}

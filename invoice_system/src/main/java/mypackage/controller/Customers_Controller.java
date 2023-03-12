package mypackage.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Customers;
import mypackage.model.Email;
import mypackage.services.Customers_Service;
import mypackage.services.EmailServiceImplementation;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class Customers_Controller {

	@Autowired
	Customers_Service cust_service;
	
	@Autowired
	EmailServiceImplementation email;
	
	@GetMapping("api/customer")
	public List<Customers> getAll(){
		return cust_service.get_All_Cust();
		
	}
	
	@GetMapping("api/customerbyid")
	public Customers getAllById(int id){
		return cust_service.get_All_Cust_By_Id(id);
		
	}
	@PostMapping("api/customer")
	public String addcustomer(@RequestBody Customers cust){
		Email obj= new Email(cust.getEmail(),"Your Account Created ",cust.getCustomer_name()+"\n"+cust.getMobile_number());
		email.SimpleEmail(obj);
		return "customer added "+cust_service.add_Customer(cust);
		
	}
	
	@PutMapping("api/customer")
	public String updatecustomer(@RequestBody Customers cust){
		return "customer updated "+cust_service.update_Customers(cust);
		
	}
	
	@DeleteMapping("api/customerbyid")
	public String deletecustomer(int id){
		return "customer deleted "+cust_service.delete_Customer(id);
		
	}
}

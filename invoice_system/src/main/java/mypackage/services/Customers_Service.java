package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Customers;
import mypackage.repository.I_Customers_repository;

@Service
public class Customers_Service {

	@Autowired
	I_Customers_repository cust_repo;
	
	public List<Customers> get_All_Cust(){
		List<Customers> customers = new ArrayList<Customers>();
		for(Customers cust:cust_repo.findAll()) {
			Customers cust_obj= new Customers(cust.getCustomer_id(),cust.getCustomer_name(),cust.getCity(),cust.getEmail(),cust.getMobile_number(),null);
			customers.add(cust_obj);
		}
		return customers;
	}
	
	
	public Customers get_All_Cust_By_Id(int id){
		Customers cust = cust_repo.findById(id).get();
		Customers obj=new Customers(cust.getCustomer_id(),cust.getCustomer_name(),cust.getCity(),cust.getEmail(),cust.getMobile_number(),null);
		return obj;
	}
	
	public Customers add_Customer(Customers cust){
		
		return cust_repo.save(cust);
	}
	
	public Customers update_Customers(Customers cust){
		
		return cust_repo.save(cust);
	}
	
	
	public Customers delete_Customer(int id){
		
		Customers cust = cust_repo.findById(id).get();
		cust_repo.delete(cust);
		return cust;
	}



}

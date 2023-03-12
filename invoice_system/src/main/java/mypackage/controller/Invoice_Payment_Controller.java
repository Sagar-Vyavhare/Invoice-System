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

import mypackage.model.Invoice_payments;
import mypackage.services.Invoice_payments_Service;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Invoice_Payment_Controller {

	@Autowired
	Invoice_payments_Service payment_service;
	
	@GetMapping("api/payments")
	public List<Invoice_payments> getAll(){
		return payment_service.getAllPayments();
	}
	
	@GetMapping("api/paymentsbyid")
	public Invoice_payments get_Details_by_Id(int id){
		return payment_service.getAllPaymentsByID(id);
	}
	
	@PostMapping("api/payments")
	public String addDetails(@RequestBody Invoice_payments detail){
		payment_service.addPayments(detail);
		 return "payment Done successfully";
	}
	
	@PutMapping("api/payments")
	public String updateDetails(@RequestBody Invoice_payments detail){
		payment_service.updatePayments(detail);
		 return "invoice payment updated successfully";
	}
	
	@DeleteMapping("api/paymentsbyid")
	public String deleteDetails(int id){
		payment_service.deletePayments(id);
		 return "invoice payment deleted successfully";
	}
}

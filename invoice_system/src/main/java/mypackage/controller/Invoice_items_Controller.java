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

import mypackage.model.Invoice_Items;
import mypackage.services.Invoice_Item_service;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Invoice_items_Controller {

	@Autowired
	Invoice_Item_service invoice_item_service;
	
	@GetMapping("api/invoice_item")
	public List<Invoice_Items> getAll(){
		return invoice_item_service.getAllEnvoiceItems();
	}
	
	@GetMapping("api/invoice_itembyid")
	public Invoice_Items get_Details_by_Id(int id){
		return invoice_item_service.getAllEnvoiceItemsById(id);
	}
	
	@PostMapping("api/invoice_item")
	public String addDetails(@RequestBody Invoice_Items detail){
		invoice_item_service.addEnvoiceItems(detail);
		 return "invoice items added successfully";
	}
	
	@PutMapping("api/invoice_item")
	public String updateDetails(@RequestBody Invoice_Items detail){
		invoice_item_service.updateEnvoiceItems(detail);
		 return "invoice items updated successfully";
	}
	
	@DeleteMapping("api/invoice_itembyid")
	public String deleteDetails(int id){
		invoice_item_service.deleteEnvoiceItems(id);
		 return "invoice items deleted successfully";
	}
}

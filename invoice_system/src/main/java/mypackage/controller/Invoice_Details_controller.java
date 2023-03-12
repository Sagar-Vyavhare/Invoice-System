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

import mypackage.model.Invoice_Details;
import mypackage.model.Invoice_Items;
import mypackage.model.Invoice_model;
import mypackage.services.Invoice_Details_Service;
import mypackage.services.Invoice_Item_service;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE }, allowedHeaders = "*")

public class Invoice_Details_controller {

	@Autowired
	Invoice_Details_Service details_service; 

	@Autowired
	Invoice_Item_service invoice_i_service;

	@GetMapping("api/allinvoices")
	public List<Invoice_model> getAll() {
		return details_service.get_All_Invoice_Details();
	}

	@GetMapping("api/invoice_detailsbyid")
	public Invoice_model get_Details_by_Id(int id) {
		return details_service.get_All_Invoice_Details_By_Id(id);
	}

	@PostMapping("api/invoice_details")
	public String addDetails(@RequestBody Invoice_Details detail) {
		
		Invoice_Details obj = new Invoice_Details(0, detail.getInvoice_date(), detail.getTotal_ammount(),
				detail.getCustomer(), null, null);
		Invoice_Details id = details_service.add_Details(obj);
		
//		separate invoice items from invoice details
		for (Invoice_Items i : detail.getInvoice_item()) {
			Invoice_Items in_items_obj = new Invoice_Items(0, i.getQuantity(),id,i.getItems());
			invoice_i_service.addEnvoiceItems(in_items_obj);
		}

		return "details added successfully";
	}

	@PutMapping("api/invoice_details")
	public String updateDetails(@RequestBody Invoice_Details detail) {
		details_service.update_Details(detail);
		return "details updated successfully";
	}

	@DeleteMapping("api/invoice_detailsbyid")
	public String deleteDetails(int id) {
		details_service.delete_Details(id);
		return "details deleted successfully";
	}
}

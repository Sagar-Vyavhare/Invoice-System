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

import mypackage.model.Items;
import mypackage.services.Items_Service;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")

public class Items_Controller {

	@Autowired
	Items_Service item_service;
	
	@GetMapping("api/item")
	public List<Items> getAll(){
		return item_service.getAllItems();
	}
	
	@GetMapping("api/itembyid")
	public Items get_Details_by_Id(int id){
		return item_service.getItemsById(id);
	}
	
	@PostMapping("api/item")
	public String addDetails(@RequestBody Items item){
		item_service.addItems(item);
		 return "item added successfully";
	}
	
	@PutMapping("api/item")
	public String updateDetails(@RequestBody Items detail){
		item_service.updateItems(detail);
		 return "item updated successfully";
	}
	
	@DeleteMapping("api/itembyid")
	public String deleteDetails(int id){
		item_service.deleteItems(id);
		 return "item deleted successfully";
	}
}

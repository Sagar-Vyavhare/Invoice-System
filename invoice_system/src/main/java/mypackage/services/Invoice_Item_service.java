package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Invoice_Items;
import mypackage.repository.I_Invoice_Item_Repository;

@Service
public class Invoice_Item_service {

	@Autowired
	I_Invoice_Item_Repository invoice_item_repo;
	
	
	public List<Invoice_Items> getAllEnvoiceItems(){
		List<Invoice_Items> invoice_item=new ArrayList<Invoice_Items>();
		for(Invoice_Items i_item:invoice_item_repo.findAll()) {
			Invoice_Items obj=new Invoice_Items(i_item.getInvoice_item_id(), i_item.getQuantity(), null, null);
			invoice_item.add(obj);

		}
		return invoice_item;
	}
	
	public Invoice_Items getAllEnvoiceItemsById(int id){
		Invoice_Items obj=invoice_item_repo.findById(id).get();
		Invoice_Items invoice_item=new Invoice_Items(obj.getInvoice_item_id(), obj.getQuantity(), null, null);
		return invoice_item;
	}
	
	public Invoice_Items updateEnvoiceItems( Invoice_Items invoice_item){
		return invoice_item_repo.save(invoice_item);
	}
	
	public Invoice_Items addEnvoiceItems( Invoice_Items invoice_item){
		return invoice_item_repo.save(invoice_item);
	}
	
	public Invoice_Items deleteEnvoiceItems(int id){
		Invoice_Items obj=invoice_item_repo.findById(id).get();
		invoice_item_repo.delete(obj);
		return obj;
	}
}

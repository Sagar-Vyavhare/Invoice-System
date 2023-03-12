package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Items;
import mypackage.repository.I_Items_Repository;

@Service
public class Items_Service {

	@Autowired
	I_Items_Repository item_repo;
	
	public List<Items> getAllItems(){
		List<Items> item= new ArrayList<Items>();
		for(Items i:item_repo.findAll()) {
			Items obj= new Items(i.getItem_id(), i.getItem_name(), i.getPurchase_range(), i.getSelling_range(), i.getTax(), i.getStock_quantity(), null);
			item.add(obj);
		}
		return item;
	}
	
	public Items getItemsById(int id){
		Items i = item_repo.findById(id).get();
		Items obj=new Items(i.getItem_id(), i.getItem_name(), i.getPurchase_range(), i.getSelling_range(), i.getTax(), i.getStock_quantity(), null);
		return obj;
	}
	
	public Items updateItems(Items item){
		return item_repo.save(item);
	}
	
	public Items addItems(Items item){
		return item_repo.save(item);
	}
	
	
	public Items deleteItems(int id){
		Items item = item_repo.findById(id).get();
		item_repo.delete(item);
		return item;
	}
}

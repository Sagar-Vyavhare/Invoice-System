package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	private String item_name;
	private float purchase_range;
	private float selling_range;
	private float tax;
	private int stock_quantity;
	@OneToMany(mappedBy = "items",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("items")
	private Set<Invoice_Items>invoice_items;
	
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Items(int item_id, String item_name, float purchase_range, float selling_range, float tax,
			int stock_quantity, Set<Invoice_Items> invoice_items) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.purchase_range = purchase_range;
		this.selling_range = selling_range;
		this.tax = tax;
		this.stock_quantity = stock_quantity;
		this.invoice_items = invoice_items;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public float getPurchase_range() {
		return purchase_range;
	}
	public void setPurchase_range(float purchase_range) {
		this.purchase_range = purchase_range;
	}
	public float getSelling_range() {
		return selling_range;
	}
	public void setSelling_range(float selling_range) {
		this.selling_range = selling_range;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public Set<Invoice_Items> getInvoice_items() {
		return invoice_items;
	}
	public void setInvoice_items(Set<Invoice_Items> invoice_items) {
		this.invoice_items = invoice_items;
	}
	
}

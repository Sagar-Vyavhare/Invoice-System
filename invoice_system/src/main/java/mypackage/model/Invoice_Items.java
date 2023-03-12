package mypackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice_items")
public class Invoice_Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_item_id;
	private int quantity;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="invoice_id",nullable = false)
	private Invoice_Details invoice_details;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="item_id",nullable = false)
	private Items items;
	
	public Invoice_Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice_Items(int invoice_item_id, int quantity, Invoice_Details invoice_details, Items items) {
		super();
		this.invoice_item_id = invoice_item_id;
		this.quantity = quantity;
		this.invoice_details = invoice_details;
		this.items = items;
	}
	public int getInvoice_item_id() {
		return invoice_item_id;
	}
	public void setInvoice_item_id(int invoice_item_id) {
		this.invoice_item_id = invoice_item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Invoice_Details getInvoice_details() {
		return invoice_details;
	}
	public void setInvoice_details(Invoice_Details invoice_details) {
		this.invoice_details = invoice_details;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	
	
}

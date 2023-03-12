package mypackage.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoice_details")
public class Invoice_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;
	private String invoice_date;
	private float total_ammount; 
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "customer_id",nullable = false)
	private Customers customer;
	
	
	@OneToMany(mappedBy = "invoice_details",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("invoice_details")
	private Set<Invoice_Items> invoice_item;
	
	
	@OneToMany(mappedBy = "invoice_details",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("invoice_details")
	private Set<Invoice_payments>invoice_payment;
	
	
	public Invoice_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice_Details(int invoice_id, String invoice_date, float total_ammount, Customers customer,Set<Invoice_Items> invoice_item, Set<Invoice_payments> invoice_payment) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_date = invoice_date;
		this.total_ammount = total_ammount;
		this.customer = customer;
		this.invoice_item = invoice_item;
		this.invoice_payment = invoice_payment;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public String getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}
	public float getTotal_ammount() {
		return total_ammount;
	}
	public void setTotal_ammount(float total_ammount) {
		this.total_ammount = total_ammount;
	}
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	public Set<Invoice_Items> getInvoice_item() {
		return invoice_item;
	}
	public void setInvoice_item(Set<Invoice_Items> invoice_item) {
		this.invoice_item = invoice_item;
	}
	public Set<Invoice_payments> getInvoice_payment() {
		return invoice_payment;
	}
	public void setInvoice_payment(Set<Invoice_payments> invoice_payment) {
		this.invoice_payment = invoice_payment;
	}
}

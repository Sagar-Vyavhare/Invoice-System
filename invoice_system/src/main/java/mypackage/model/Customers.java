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
@Table(name="customer")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private String city;
	private String email;
	private long mobile_number;
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("customer")
	private Set<Invoice_Details> Invoice_Details;
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(int customer_id, String customer_name, String city, String email, long mobile_number,
			Set<mypackage.model.Invoice_Details> invoice_Details) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.city = city;
		this.email = email;
		this.mobile_number = mobile_number;
		Invoice_Details = invoice_Details;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public Set<Invoice_Details> getInvoice_Details() {
		return Invoice_Details;
	}
	public void setInvoice_Details(Set<Invoice_Details> invoice_Details) {
		Invoice_Details = invoice_Details;
	} 
}

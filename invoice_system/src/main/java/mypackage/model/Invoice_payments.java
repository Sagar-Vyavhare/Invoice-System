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
@Table(name="invoice_payment")
public class Invoice_payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payment_id;
	private String payment_date;
	private float payment_ammount;
	private String payment_mode;
	private String description_print;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="invoice_id",nullable = false)
	private Invoice_Details invoice_details;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public float getPayment_ammount() {
		return payment_ammount;
	}
	public void setPayment_ammount(float payment_ammount) {
		this.payment_ammount = payment_ammount;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getDescription_print() {
		return description_print;
	}
	public void setDescription_print(String description_print) {
		this.description_print = description_print;
	}
	public Invoice_Details getInvoice_details() {
		return invoice_details;
	}
	public void setInvoice_details(Invoice_Details invoice_details) {
		this.invoice_details = invoice_details;
	}
	public Invoice_payments(int payment_id, String payment_date, float payment_ammount, String payment_mode,
			String description_print, Invoice_Details invoice_details) {
		super();
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.payment_ammount = payment_ammount;
		this.payment_mode = payment_mode;
		this.description_print = description_print;
		this.invoice_details = invoice_details;
	}
	public Invoice_payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

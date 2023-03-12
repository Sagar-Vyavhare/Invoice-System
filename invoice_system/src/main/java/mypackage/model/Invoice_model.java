package mypackage.model;

public class Invoice_model {

	private int invoice_id;
	private int customer_id;
	private String customer_name;
	private String invoice_date;
	private float total_ammount;
	private float paid_ammount;
	private float remaining_ammount;
	private String status;
	
	public Invoice_model() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice_model(int invoice_id, int customer_id, String customer_name, String invoice_date,
			float total_ammount, float paid_ammount, float remaining_ammount, String status) {
		super();
		this.invoice_id = invoice_id;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.invoice_date = invoice_date;
		this.total_ammount = total_ammount;
		this.paid_ammount = paid_ammount;
		this.remaining_ammount = remaining_ammount;
		this.status = status;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
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
	public float getPaid_ammount() {
		return paid_ammount;
	}
	public void setPaid_ammount(float paid_ammount) {
		this.paid_ammount = paid_ammount;
	}
	public float getRemaining_ammount() {
		return remaining_ammount;
	}
	public void setRemaining_ammount(float remaining_ammount) {
		this.remaining_ammount = remaining_ammount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

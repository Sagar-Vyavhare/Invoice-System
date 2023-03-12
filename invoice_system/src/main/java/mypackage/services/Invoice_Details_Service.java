package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mypackage.model.Invoice_Details;
import mypackage.model.Invoice_model;
import mypackage.model.Invoice_payments;
import mypackage.repository.I_Invoice_Details_Repository;
import mypackage.repository.I_Invoice_Payment_Repository;

@Service
public class Invoice_Details_Service {

	@Autowired
	I_Invoice_Details_Repository invoice_repo;
	
	@Autowired
	I_Invoice_Payment_Repository payment_repo;

	public List<Invoice_model> get_All_Invoice_Details() {
		List<Invoice_model> lst =new ArrayList<Invoice_model>();
		for (Invoice_Details detail : invoice_repo.findAll()) {
			float paid_ammount = 0;
			float total_ammount = detail.getTotal_ammount();
			float remaining_ammount = 0;
			String status;
			for(Invoice_payments p:payment_repo.findAll()) {
				if(p.getInvoice_details().getInvoice_id()==detail.getInvoice_id()) {
					paid_ammount+=p.getPayment_ammount();
				}
			}
			remaining_ammount = total_ammount - paid_ammount;
			total_ammount = detail.getTotal_ammount();
			if (paid_ammount == total_ammount) {
				status = "Paid";
			} else if (remaining_ammount < total_ammount && remaining_ammount != 0) {
				status = "Partion paid";
			} else {
				status = "Unpaid";
			}
			Invoice_model obj = new Invoice_model(detail.getInvoice_id(), detail.getCustomer().getCustomer_id(),
					detail.getCustomer().getCustomer_name(), detail.getInvoice_date(), total_ammount, paid_ammount,
					remaining_ammount, status);
			lst.add(obj);
		}
		return lst;
	}

	public Invoice_model get_All_Invoice_Details_By_Id(int id) {
		Invoice_model obj=null;
		for(Invoice_model detail:get_All_Invoice_Details()) {
			if(id==detail.getInvoice_id()) {
				obj=new Invoice_model(detail.getInvoice_id(), detail.getCustomer_id(), detail.getCustomer_name(), detail.getInvoice_date(), detail.getTotal_ammount(), detail.getPaid_ammount(), detail.getRemaining_ammount(), detail.getStatus());
			}
		}
		return obj;

	}

	public Invoice_Details add_Details(Invoice_Details detail) {
		Invoice_Details id = invoice_repo.save(detail);
		return id;

	}

	public Invoice_Details update_Details(Invoice_Details detail) {
		return invoice_repo.save(detail);

	}

	public Invoice_Details delete_Details(int id) {
		Invoice_Details obj = invoice_repo.findById(id).get();
		invoice_repo.delete(obj);
		return obj;

	}
}

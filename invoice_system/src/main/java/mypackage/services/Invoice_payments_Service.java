package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Customers;
import mypackage.model.Invoice_Details;
import mypackage.model.Invoice_payments;
import mypackage.repository.I_Invoice_Payment_Repository;

@Service
public class Invoice_payments_Service {

	@Autowired
	I_Invoice_Payment_Repository invoice_pay_repo;

	public List<Invoice_payments> getAllPayments() {
		List<Invoice_payments> invoice_payments = new ArrayList<Invoice_payments>();
		for (Invoice_payments payment : invoice_pay_repo.findAll()) {
			Customers cust = new Customers(payment.getInvoice_details().getCustomer().getCustomer_id(), payment.getInvoice_details().getCustomer().getCustomer_name(), payment.getInvoice_details().getCustomer().getCity(), payment.getInvoice_details().getCustomer().getEmail(), payment.getInvoice_details().getCustomer().getMobile_number(), null);
			Invoice_Details details=new Invoice_Details(payment.getInvoice_details().getInvoice_id(), payment.getInvoice_details().getInvoice_date(), payment.getInvoice_details().getTotal_ammount(),cust, null, null);
			Invoice_payments obj = new Invoice_payments(payment.getPayment_id(), payment.getPayment_date(),
					payment.getPayment_ammount(), payment.getPayment_mode(), payment.getDescription_print(), details);
			invoice_payments.add(obj);
		}
		return invoice_payments;
	}

	public Invoice_payments getAllPaymentsByID(int id) {
		Invoice_payments payment = invoice_pay_repo.findById(id).get();
		Invoice_payments obj = new Invoice_payments(payment.getPayment_id(), payment.getPayment_date(),
				payment.getPayment_ammount(), payment.getPayment_mode(), payment.getDescription_print(), null);

		return obj;
	}

	public Invoice_payments addPayments(Invoice_payments payment) {
		return invoice_pay_repo.save(payment);
	}

	public Invoice_payments updatePayments(Invoice_payments payment) {
		return invoice_pay_repo.save(payment);
	}

	public Invoice_payments deletePayments(int id) {
		Invoice_payments obj = invoice_pay_repo.findById(id).get();
		invoice_pay_repo.delete(obj);
		return obj;
	}
}

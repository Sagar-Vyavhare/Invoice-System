package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Invoice_payments;

public interface I_Invoice_Payment_Repository extends JpaRepository<Invoice_payments, Integer> {

}

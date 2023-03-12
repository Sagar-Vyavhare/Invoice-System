package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Invoice_Details;

public interface I_Invoice_Details_Repository extends JpaRepository<Invoice_Details, Integer>{

}

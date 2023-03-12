package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Invoice_Items;

public interface I_Invoice_Item_Repository extends JpaRepository<Invoice_Items, Integer> {

}

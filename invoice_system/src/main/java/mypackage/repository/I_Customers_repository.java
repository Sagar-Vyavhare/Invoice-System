package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Customers;

public interface I_Customers_repository extends JpaRepository<Customers, Integer>{

}

package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.Items;

public interface I_Items_Repository extends JpaRepository<Items, Integer> {

}

package com.bolton.treehouseproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolton.treehouseproject.domains.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	

}

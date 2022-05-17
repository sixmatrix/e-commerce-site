package com.bolton.treehouseproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolton.treehouseproject.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Suppliers;


@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Integer> {

}

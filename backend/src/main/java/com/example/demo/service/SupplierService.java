package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Suppliers;
import com.example.demo.repository.SupplierRepository;

@Service
public class SupplierService {
	
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	//Get all suppliers
	public List<Suppliers> getSuppliers() {
		return supplierRepository.findAll();
	}
	
	
	// Get supplier by Id
	public Optional<Suppliers> getSupplierByID(Integer id) {
		return supplierRepository.findById(id);
	}
	
	
	// Create new supplier
	public Suppliers createSupplier(Suppliers supplier) {
		return supplierRepository.save(supplier);
	}
	
	
	// Update existing supplier
	public Suppliers updateSuppliers(Integer id,Suppliers supplier)
	{
		if(supplierRepository.existsById(id)) {
			supplier.setId(id);
			return supplierRepository.save(supplier);
		}
		return null;
	}
	
	
	// Delete supplier
	public void deleteSuppliers(Integer id) {
		supplierRepository.deleteById(id);
		
	}

}

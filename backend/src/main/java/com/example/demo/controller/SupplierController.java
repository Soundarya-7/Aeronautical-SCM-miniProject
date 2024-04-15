package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Suppliers;
import com.example.demo.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

   
	public SupplierController(SupplierService service) {
		this.supplierService = service;
	}

	@GetMapping
    public List<Suppliers> getSuppliers() {
        return supplierService.getSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suppliers> getSupplierByIDSuppliers(@PathVariable Integer id) {
        Optional<Suppliers> supplier = supplierService.getSupplierByID(id);
        return supplier.map(s -> ResponseEntity.ok().body(s))
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Suppliers> createSuppliers(@RequestBody Suppliers supplier) {
        Suppliers createdSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSupplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suppliers> updateSuppliers(@PathVariable Integer id, @RequestBody Suppliers supplier) {
        Suppliers updatedSupplier = supplierService.updateSuppliers(id, supplier);
        return ResponseEntity.ok().body(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuppliers(@PathVariable Integer id) {
        supplierService.deleteSuppliers(id);
        return ResponseEntity.noContent().build();
    }
}


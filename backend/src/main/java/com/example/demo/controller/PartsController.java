package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Parts;
import com.example.demo.service.PartsService;


@RestController
@RequestMapping("/parts")
@CrossOrigin(origins = "*")
public class PartsController {
	
	
	
	@Autowired
	private PartsService partsService;
	
	
	@GetMapping
	public List<Parts> getAllParts(){
		return partsService.getAllParts();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Parts> getPartById(@PathVariable Integer id) {
		return partsService.getPartById(id);
	}
	
	@PostMapping
	public Parts createParts(@RequestBody Parts parts)
	{
		return partsService.createParts(parts);
	}
	
	
	@PutMapping("/{id}")
	public Parts updateParts(@PathVariable Integer id, @RequestBody Parts parts) {
		return partsService.updateParts(id, parts);
	}
	
	@DeleteMapping("/{id}")
	public void deleteParts(@PathVariable Integer id) {
		partsService.deleteParts(id);
	}

}

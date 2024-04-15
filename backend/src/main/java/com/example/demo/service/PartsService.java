package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Parts;
import com.example.demo.repository.PartsRepository;

@Service
public class PartsService {
	
	
	@Autowired
	private PartsRepository partsRepository;
	
	
	// Get all parts
	public List<Parts> getAllParts(){
		
		return partsRepository.findAll();
	}
	
	// fetch part by Id
	public Optional<Parts> getPartById(Integer id) {
		
		return partsRepository.findById(id);
	}
	
	// Create new part
	public Parts createParts(Parts part) {
		return partsRepository.save(part);
	}
	
	
	// update existing part
	public Parts updateParts(Integer id, Parts part)
	{
		if(partsRepository.existsById(id))
		{
			part.setId(id);
			return partsRepository.save(part);
		}
		return null;
	}
	
	
	// Delete part
	public void deleteParts(Integer id) {
		
		partsRepository.deleteById(id);
	}

}

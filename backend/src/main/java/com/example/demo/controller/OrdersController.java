package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.service.OrdersService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrdersController {
	
	
	
	@Autowired
	private OrdersService ordersService;
	
	
	@GetMapping
	public List<Orders> getAllOrders(){
		return ordersService.getAllOrders();
	}
	
	
	@PostMapping
	public Orders createOrders(@RequestBody Orders orders) {
		return ordersService.createOrders(orders);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrders(@PathVariable Integer id) {
		ordersService.deleteOrders(id);
	}
	

}

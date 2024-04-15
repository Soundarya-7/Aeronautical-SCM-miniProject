package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;
import com.example.demo.repository.OrdersRepository;

@Service
public class OrdersService {
	
	
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	
	public List<Orders> getAllOrders(){
		return ordersRepository.findAll();
	}

	
	public Optional<Orders> getOrderById(Integer id) {
		return ordersRepository.findById(id);
	}
	
	
	
	public Orders createOrders(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	
	public void deleteOrders(Integer id) {
		ordersRepository.deleteById(id);
		
	}
}

package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.*;



@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "parts_id")
	private Parts parts;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade =  {CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "supplier_id")
	private Suppliers suppliers;
	
	
	private long quantity;
	
	private Date orderDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Orders(Integer id, Parts parts, Suppliers suppliers, long quantity, Date orderDate) {
		super();
		this.id = id;
		this.parts = parts;
		this.suppliers = suppliers;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}

	public Orders() {
		super();
	}
	
	
	

}

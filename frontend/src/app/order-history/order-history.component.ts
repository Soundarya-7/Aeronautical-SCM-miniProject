import { Component, OnInit } from '@angular/core';
import { SupplierService } from '../supplier.service';
import { Orders } from './orders.model';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {


  orders : Orders[]
  constructor(private service : SupplierService) { }

  ngOnInit() {

    this.fetchOrders()
  }


  fetchOrders(){

    this.service.getAllOrders().subscribe(
      orders=>{
        this.orders = orders;
      }
    )

  }
}

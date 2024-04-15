import { Component, OnInit } from '@angular/core';
import { SupplierService } from '../supplier.service';
import { Supplier } from '../update-supplier/update-supplier.model';

@Component({
  selector: 'app-all-supplier',
  templateUrl: './all-supplier.component.html',
  styleUrls: ['./all-supplier.component.css']
})
export class AllSupplierComponent implements OnInit {


  supplier : Supplier[] 

  constructor(private service : SupplierService) { }

  ngOnInit() {
    this.fetchSuppliers();
  }


  fetchSuppliers(){

    this.service.getAllSuppliers().subscribe(
      suppliers => {
        this.supplier = suppliers.sort((a: any , b : any)=> a.id - b.id)
      }
    )

  }

}
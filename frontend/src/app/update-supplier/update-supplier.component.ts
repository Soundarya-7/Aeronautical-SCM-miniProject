import { Component, OnInit } from '@angular/core';
import { SupplierService } from '../supplier.service';
import { Supplier } from './update-supplier.model';

@Component({
  selector: 'app-update-supplier',
  templateUrl: './update-supplier.component.html',
  styleUrls: ['./update-supplier.component.css']
})
export class UpdateSupplierComponent implements OnInit {

  
  supplier :  Supplier 

  id : number

  constructor(private service : SupplierService) {
    this.supplier = new Supplier(); 

  }

  ngOnInit() {
  }


  findSupplier(){

    this.service.getSupplierById(this.id).subscribe(

      (supplier)=>{
        this.supplier = supplier;
      }
    )

    
  }

  submit(){

  this.service.updateSupplier(this.id, this.supplier).subscribe(
    supplier =>{
      alert('product updated')
    }
  )
  }

}

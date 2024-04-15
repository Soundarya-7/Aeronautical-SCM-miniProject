import { Component, OnInit } from '@angular/core';
import { SupplierService } from '../supplier.service';
import { Supplier } from '../update-supplier/update-supplier.model';

@Component({
  selector: 'app-delete-supplier',
  templateUrl: './delete-supplier.component.html',
  styleUrls: ['./delete-supplier.component.css']
})
export class DeleteSupplierComponent implements OnInit {


  supplier :  Supplier 
  id : number


  constructor(private service : SupplierService) {

    this.supplier = new Supplier();
   }


  ngOnInit() {

  }

  
findSupplier(){

  this.service.getSupplierById(this.id).subscribe(
    supplier => {
      this.supplier= supplier;
    }
  )
 
}
  submit(){

    // if else = > prompt yes or no
   
    alert('Are you sure want to delete?')
    this.service.deleteSupplier(this.id).subscribe(
      response =>{
        console.log('Supplier deleted successfully')
       
      },

      error => {
        console.error('error occurred while deleting')
      }
    )
    
   this.supplier = {
     name : "",
     address : "",
     phoneNumber : null
   }
  }

}

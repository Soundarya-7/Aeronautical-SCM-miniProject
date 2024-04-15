import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SupplierService } from '../supplier.service';
import { Supplier } from '../update-supplier/update-supplier.model';

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit {


  constructor(private service : SupplierService) {
   }

  ngOnInit() {
  }


  submit(formData : NgForm){

    if(formData.valid){

          const s = formData.value
          console.log('form data : ', s)
          this.service.createSupplier(s).subscribe(
            response => {
              console.log('Supplier added successfully', response);
              alert('Added successfully')
            },

            error => {
              console.error('Error occurred', error)
            }
          
          )

          formData.resetForm();
    
        }
    
  }

}

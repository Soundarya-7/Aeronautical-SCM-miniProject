import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Supplier } from './update-supplier/update-supplier.model';
import { Orders } from './order-history/orders.model';


@Injectable({
  providedIn: 'root'
})
export class SupplierService {


  apiURL : string = "http://localhost:5050/suppliers"

  orderURL : string = "http://localhost:5050/orders"

  constructor(private http : HttpClient) {}


  getAllSuppliers() : Observable<Supplier[]>{
    return this.http.get<Supplier[]>(this.apiURL)
  }


  getSupplierById(id : number) : Observable<Supplier>{
    return this.http.get<Supplier>(this.apiURL+'/' + id)
  }

  updateSupplier(id: number, supplierData: Supplier) : Observable<Supplier>{
    const url = `${this.apiURL}/${id}`
    return this.http.put<Supplier>(url, supplierData);
  }


  createSupplier(supplierData : Supplier ): Observable<Supplier>{

    return this.http.post<Supplier>(this.apiURL,supplierData);
  }

  deleteSupplier(id : number) : Observable<Supplier>{
    const url = `${this.apiURL}/${id}`
    return this.http.delete<Supplier>(url)
  }


  getAllOrders(): Observable<Orders[]>{
    return this.http.get<Orders[]>(this.orderURL)
  }
  
}

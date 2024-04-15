import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllSupplierComponent } from './all-supplier/all-supplier.component';
import { DeleteSupplierComponent } from './delete-supplier/delete-supplier.component';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { SupplierComponent } from './supplier/supplier.component';
import { UpdateSupplierComponent } from './update-supplier/update-supplier.component';


const routes: Routes = [
  {path: 'allSupplier' , component: AllSupplierComponent},
  {path: 'addSupplier' , component:SupplierComponent},
  {path:'updateSupplier' , component: UpdateSupplierComponent},
  {path : 'deleteSupplier', component: DeleteSupplierComponent},

  {path: 'orderHistory', component: OrderHistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

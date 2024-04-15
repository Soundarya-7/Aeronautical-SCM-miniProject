import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SupplierComponent } from './supplier/supplier.component';
import { FormsModule } from '@angular/forms';
import { UpdateSupplierComponent } from './update-supplier/update-supplier.component';
import { DeleteSupplierComponent } from './delete-supplier/delete-supplier.component';
import { AllSupplierComponent } from './all-supplier/all-supplier.component';
import { HttpClientModule } from '@angular/common/http';
import { OrderHistoryComponent } from './order-history/order-history.component';

@NgModule({
  declarations: [
    AppComponent,
    SupplierComponent,
    UpdateSupplierComponent,
    DeleteSupplierComponent,
    AllSupplierComponent,
    OrderHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

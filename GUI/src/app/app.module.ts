import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './myComponents/employee/employee.component';
import { HttpClientModule } from '@angular/common/http';
import { GnericServiceService } from './Service/gneric-service.service';

import { EditEmployeeComponent } from './myComponents/edit-employee/edit-employee.component';
import { AddEmployeeComponent } from './myComponents/add-employee/add-employee.component';
import { ReactiveFormsModule } from '@angular/forms';
import { StudentComponent } from './myComponents/student/student/student.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    EditEmployeeComponent,
    AddEmployeeComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [GnericServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

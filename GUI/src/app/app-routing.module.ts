import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEmployeeComponent } from './myComponents/add-employee/add-employee.component';
import { EditEmployeeComponent } from './myComponents/edit-employee/edit-employee.component';
import { EmployeeComponent } from './myComponents/employee/employee.component';


const routes: Routes = [
  { path: 'employee', component: EmployeeComponent },
  { path: 'Addemployee', component: AddEmployeeComponent },
  { path: 'Editemployee/:id', component: EditEmployeeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }

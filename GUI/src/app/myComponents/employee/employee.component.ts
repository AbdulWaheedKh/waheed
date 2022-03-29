import { Component, OnInit } from '@angular/core';
import { EmployeesModel } from 'src/app/Models/employeeModel';
import { GnericServiceService } from 'src/app/Service/gneric-service.service';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
employees:EmployeesModel[]=[];
searchText:any;
  constructor(private gnerService:GnericServiceService) { }

  ngOnInit(): void {
this.getEmployees()
    
  }
  getEmployees(){
    this.gnerService.getEmployees().subscribe(res=>{
      this.employees=res;
      console.log(res);
      
    })
  }



  deleteItem(j:number){
  this.gnerService.delEmployeeById(j).subscribe(res=>{
    console.log(res);
    this. getEmployees()
    
  })
    console.log(j);
    
      
    
  }

  // key : string = 'id';
  // reverse : boolean =false;
  // sort(key){

  //   this.key = key;
  //   this.reverse = !

  // }


  

}

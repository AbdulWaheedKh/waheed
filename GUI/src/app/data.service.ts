import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { EmployeesModel } from './Models/employeeModel';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  // configUrl1 = 'http://localhost:8080/DelEmpById';
  configUrl = 'http://localhost:8080';
  constructor(private https:HttpClient) { }

   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    })
  };
  add(data:EmployeesModel){
return this.https.post(this.configUrl+'/newEmp' ,data)
  }
}

import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders, HttpParams} from '@angular/common/http';
import { EmployeesModel } from '../Models/employeeModel';
// import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { student } from '../Models/student';


@Injectable({
  providedIn: 'root'
})
export class GnericServiceService {

  onObjectChanged!: BehaviorSubject<any>;
  constructor(private http: HttpClient ) { }

   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'

      // 'Content-Type': 'application/json',
      //           'Access-Control-Allow-Origin': '*',
      //           'Access-Control-Allow-Credentials': 'true',
      //           'Access-Control-Allow-Headers': 'Content-Type',
      //           'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE',
      //           'key': 'x-api-key',
      //           'value': 'NNctr6Tjrw9794gFXf3fi6zWBZ78j6Gv3UCb3y0x'

      // 'Content-Type':  'application/json'

    })
  };
  configUrl = 'http://localhost:8081/waheed';
  configUrl1 = 'http://localhost:8080/DelEmpById';

  getEmployees(): Observable<EmployeesModel[]>{
    return this.http.get<EmployeesModel[]>(this.configUrl+'/getAll')
  }

  getEmployeeById(  id : Number ): Observable<EmployeesModel>{
    return this.http.get<EmployeesModel>(this.configUrl+'/'+ id)
  }

  delEmployeeById(id:number ): Observable<EmployeesModel>{
    return this.http.delete<EmployeesModel>(this.configUrl+'/'+ id)
  }

  getCurrentEmployeeById(id:any){
    return this.http.get(`${this.configUrl+'/getEmpById'}/${id}`)
  }

  // updateCurrentEmployeeById(id:any,data:EmployeesModel){
  //   return this.http.put(`${this.configUrl+'/editEmp'}/${id}`,data,this.httpOptions)
  // }


  updateCurrentEmployeeById(standardSubject: EmployeesModel): Promise<any> {
    return new Promise((resolve, reject) => {

      console.log("sevice called");
      
      this.http.put(this.configUrl + '/editEmp/'+standardSubject.id, { ...standardSubject })
        .subscribe(response => {
          console.log("after subscribed");
          resolve(response);
          
          
        },
        err => {
         // console.log(err.error.message);
          reject(err);       
        },
        () => console.log(' No Data----')  
        
        );
    });
  }

//for student withour model 

  getStudents(): Observable<student[]>{
    return this.http.get<student[]>(this.configUrl+'/getAllStudents')
  }

}

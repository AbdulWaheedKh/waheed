import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from 'src/app/data.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

alert : boolean = false;

  addEmployee = new FormGroup({
    id : new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    salary: new FormControl('')
  })

  constructor(private data:DataService, private router:Router) { }

  ngOnInit(): void {
  }
  onSubmit(){
    console.log(this.addEmployee.value);
    this.data.addEmployee(this.addEmployee.value).subscribe((res)=>{
      this.alert = true;
    })
    this.router.navigateByUrl("/employee");
    };

    closeButton(){
      this.alert = false;
    }


    
  }



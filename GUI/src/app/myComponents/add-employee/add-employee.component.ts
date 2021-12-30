import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl } from '@angular/forms';
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

  constructor(private data:DataService) { }

  ngOnInit(): void {
  }
  onSubmit(){
    console.log(this.addEmployee.value);
    this.data.add(this.addEmployee.value).subscribe((res)=>{
      console.log('result' , res);
      
    })
    this.alert = true;
    this.addEmployee.reset();
    };

    closeButton(){
      this.alert = false;
    }


    
  }



import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GnericServiceService } from 'src/app/Service/gneric-service.service';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  alert : boolean = false;

  editEmployee = new FormGroup({
    id : new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
  salary: new FormControl('')
  })

  constructor(private route: ActivatedRoute, private service:GnericServiceService,  private router: Router) { }

  ngOnInit(): void {
    console.log(this.route.snapshot.params.id);
    this.service.getCurrentEmployeeById(this.route.snapshot.params.id).subscribe((result:any)=>
    {
      console.log(this.route.snapshot.params.id);
       //this.editEmployee.controls['id'].setValue(result['id']);
      this.editEmployee = new FormGroup({
        id : new FormControl(result['id']),
        firstName: new FormControl(result['firstName']),
        lastName: new FormControl(result['lastName']),
      salary: new FormControl(result['salary'])
      })

    }
    )
  }

  update(){
    console.log(this.editEmployee.value);
    this.service.updateCurrentEmployeeById(this.editEmployee.value)
    console.log("data valyes updatdd");
    console.log(this.editEmployee.value);
    this.alert = true;
    this.router.navigateByUrl("/employee");
  }
  closeButton(){
    this.alert = false;
  }

  

}

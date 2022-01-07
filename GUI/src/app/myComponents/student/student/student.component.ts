import { Component, OnInit } from '@angular/core';
import { student } from 'src/app/Models/student';
import { GnericServiceService } from 'src/app/Service/gneric-service.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  student : student[] = [];

  constructor(private generic:GnericServiceService) { }

  ngOnInit(): void {
    this.generic.getStudents().subscribe((res)=>{
      console.log(res);
      this.student=res;
    })
  }

}

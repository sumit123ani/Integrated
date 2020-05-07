import { Component, OnInit, ViewChild } from '@angular/core';
import { FetchService } from '../fetch.service';
import { Test } from '../test';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-test',
  templateUrl: './update-test.component.html',
  styleUrls: ['./update-test.component.css']
})
export class UpdateTestComponent implements OnInit {

@ViewChild("formdata")
form:NgForm;

  constructor(private service:FetchService) { }

  test:Test = new Test();

  ngOnInit(): void {

   this.test = this.service.getTest();
  }

  updateTest()
  {
    this.service.updateTest(this.test).subscribe(data=>
      {
        alert("successfully updated");
      },
      error=>{
          alert("error");
          console.log(error);
          
      }
      );
  }

}

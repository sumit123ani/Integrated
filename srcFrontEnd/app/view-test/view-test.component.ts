import { Component, OnInit } from '@angular/core';
import { FetchService } from '../fetch.service';
import { Test } from '../test';

@Component({
  selector: 'app-view-test',
  templateUrl: './view-test.component.html',
  styleUrls: ['./view-test.component.css']
})
export class ViewTestComponent implements OnInit {

  constructor(private service:FetchService) { }

   tests:Test[] =[];

  ngOnInit(): void {

    this.service.getTestList().subscribe(data=>
      {
        this.tests = data;
      },
      error=>
      {
        alert("error");
        console.log(error);
        
      });

  }

  deleteTest(index:number)
  {
    this.service.deleteTest(this.tests[index].testId).subscribe(data=>
    {
      alert("deleted successfully");
      this.ngOnInit();
    },
    error=>{
         alert("error");
         console.log(error);
         
    });
  }
  
  updateTest(index:number)
  {
    this.service.setTest(this.tests[index]);
  }

}

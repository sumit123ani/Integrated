import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { FetchService } from '../fetch.service';
import { User } from '../user';
import { Test } from '../test';
import { Question } from '../question';
import { Result } from '../result';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-view-result',
  templateUrl: './view-result.component.html',
  styleUrls: ['./view-result.component.css']
})
export class ViewResultComponent implements OnInit {

  constructor(private serv:FetchService, private service:AuthenticationService) { }

   title:string ="";
   totalMarks:number = 0;
   totalScore:number = 0;
   questions:Question[] = [];
  //  test:Test = new Test();
   tests:Test[] =[];
   user:User = new User();
   results:Result[] =[];

   question:Question = new Question();
 
   noOfQuestion:number =0;
   currentQuestion:number =0;

   flag:boolean = true;

  ngOnInit(): void {

   if(this.flag)
     this.load();
   }


   load()
   {
    this.user = this.service.getUser();
 
    alert(this.user.userId)
    this.serv.getResultList(this.user.userId).subscribe(data=>
     {
       this.results = data;
       alert("result")

       this.totalMarks += this.results[0].totalMarks; 
       this.totalScore += this.results[0].totalScore;
       this.title = this.results[0].testTitle;

       for(var i=0; i<this.results.length; i++)
      {
      this.serv.getOneTest(this.results[i].testId).subscribe(data=>
       {
         this.tests[i] = data;
        // alert(this.tests[i].testTitle);

         this.flag = false;
       },
       error=>{
           alert("error");
       }
       );
     }
     },
     error=>{
       alert("error");
     });
    }
  //  this.title = this.test.testTitle
  //  this.totalMarks = this.test.testTotalMarks;
  //  this.totalScore = this.test.testMarksScored;

  //  alert(this.questions[0].chosenAnswer);
  //  this.noOfQuestion = this.questions.length;
  
  show(index:number)
  {
    alert(index)
    alert(this.results[index].testTitle)
  
    this.totalMarks =0;
    this.totalScore =0;

    this.title = this.results[index].testTitle;
    this.totalMarks = this.totalMarks+this.results[index].totalMarks;
    this.totalScore = this.totalScore+this.results[index].totalScore;

    
    this.ngOnInit();
  }


}

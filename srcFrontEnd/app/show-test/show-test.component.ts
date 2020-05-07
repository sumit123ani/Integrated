import { Component, OnInit } from '@angular/core';
import { Test } from '../test';
import { FetchService } from '../fetch.service';
import { User } from '../user';
import { AuthenticationService } from '../authentication.service';
import { Question } from '../question';


@Component({
  selector: 'app-show-test',
  templateUrl: './show-test.component.html',
  styleUrls: ['./show-test.component.css']
})
export class ShowTestComponent implements OnInit {

  constructor(private service:FetchService, private serv:AuthenticationService) { }

  user:User = new User();
  testType:string ="";
  test:Test = new Test();
  tests:Test[];
  tests1:Test[];
  question:Question = new Question();

  ngOnInit(): void {

   this.user = this.serv.getUser();
   
   this.service.getTestList().subscribe(data=>
    {
      this.tests = data;
    },
    error=>
    {
      console.log("error occured", error);
    });
  }

  submit()
  {
    if(this.testType.length != 0)
          this.tests = this.tests.filter((t) => t.testTitle.startsWith(this.testType));

          else
           this.ngOnInit();

  }

   giveTest(index:number)
   {
     this.service.setTest(this.tests[index]);
     this.tests[index].testMarksScored = null;
     this.service.assignTest(this.tests[index]).subscribe(data=>
      {
        console.log("assigned");
        
      },
      error=>{
    console.log(error);
    alert("can not assign");

      });

 
      for(var i =0; i<this.tests[index].testQuestions.length; i++)
      {
        this.question = this.tests[index].testQuestions[i];
        this.question.chosenAnswer = null;
        this.question.marksScored =null;
        this.service.updateQuestion(this.question).subscribe(data=>
          {
            console.log("successfull");
            
          },
          error=>{
              console.log("not successful");
              
          })
      }
  

   } 

}

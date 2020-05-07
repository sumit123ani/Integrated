import { Component, OnInit, ViewChild } from '@angular/core';
import { Question } from '../question';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';
import { Test } from '../test';


@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

 @ViewChild("#formdata")
 form:NgForm;

  constructor(private service:FetchService) { }

  temp:number =0;
  id:number;
  question:Question;
  questions:Question[] =[];
  test:Test;

  errorMsg:string ="";
  msg:string ="";

  flag:boolean = true;

  ngOnInit(): void {
    this.question = new Question();
    this.test = new Test();
  }

  createQuestion()
  {
    for(var i =0; i<this.test.testQuestions.length; i++){
     if(this.test.testQuestions[i].questionId == this.question.questionId){
       alert("question already exists")
       this.flag = false;
     }
    }

    if(this.flag){
    this.test.testQuestions.push(this.question);

    this.service.addQuestionToTest(this.test).subscribe(data=>
      {
        this.msg = data;
        this.errorMsg = undefined;
        alert(this.msg)
        this.ngOnInit();
        this.getTest();
      },
      error=>
      {
        this.errorMsg = JSON.parse(error.error).massege;
        alert(this.errorMsg);
      })
    }
  }

 getTest()
 {
   this.service.getOneTest(this.id).subscribe(data=>
    {
      this.test = data;
      if(this.test == null)
      {
        alert("no such test exists");
      }
      else
      alert("success")
    },
   error=> {
           alert("no test exists");
    })
  
 }

show()
{
    this.questions = this.service.retrievQuest();
    for(var i=0; i<this.questions.length; i++)
    alert(this.questions[i].questionId);
  
}

}

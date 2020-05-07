import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FetchService } from '../fetch.service';
import { Question } from '../question';



@Component({
  selector: 'app-update-question',
  templateUrl: './update-question.component.html',
  styleUrls: ['./update-question.component.css']
})
export class UpdateQuestionComponent implements OnInit {

  @ViewChild("#formdata")
  form:NgForm;

  constructor(private service:FetchService) { }

  question:Question = new Question();

  ngOnInit(): void {
    this.question = this.service.getQuestion();
  }

 updateQuestion()
 {
   this.service.updateQuestion(this.question).subscribe(data=>
    {
      alert("updated successfully");
    },
    error=>
    {
      alert("can't update");
      console.log("error occured", error);
    })
 }

}

import { Component, OnInit } from '@angular/core';
import { FetchService } from '../fetch.service';
import { Question } from '../question';

@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {

  constructor(private service:FetchService) { }

  questions:Question[];
   quest:Question[];

  ngOnInit(): void {

   this.service.getAllQuestion().subscribe(data=>
    {
      this.questions = data;
      // alert(this.questions[9].option[0])
    },
    error=>{
        alert("error occured");
        console.log("error occured", error);
        
    });
    
  }

  delete(index:number)
  {
    let id = this.questions[index].questionId;
    this.service.deleteQuestion(id).subscribe(data=>
      {
        alert("deleted successfully");
        this.ngOnInit();
      },
      error=>{
          alert("can't delete");
          console.log("error occured", error);
          
      });
  }

  update(index:number)
  {
     alert(this.questions[index].questionTitle)
     this.service.setQuestion(this.questions[index]);
  }
   
}

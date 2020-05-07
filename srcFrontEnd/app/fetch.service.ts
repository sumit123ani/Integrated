import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { Test } from './test';
import { Question } from './question';
import { Result } from './result';

@Injectable({
  providedIn: 'root'
})
export class FetchService {

  flag:boolean;
user:User = new User();
question:Question = new Question();
test:Test = new Test();

questions:Question[]=[];

  constructor(private _http:HttpClient) { }

  createUser(user:User):Observable<any>
  {
    let url = "http://localhost:1998/user/new";
    return this._http.post(url, user, {responseType:'text'})
  }

 createTest(test:Test):Observable<any>
 {
   let url = "http://localhost:1998/test/new";
   return this._http.post(url, test, {responseType:'text'});
 }

 createQuestion(question:Question):Observable<any>
 {
   let url = "http://localhost:1998/question/new";
   return this._http.post(url, question, {responseType:'text'})
 }

  getUser(id:number):Observable<any>
  {
    let url = "http://localhost:1998/user/"+id;
    return this._http.get(url);
  }

 getTestList():Observable<any>
 {
   let url = "http://localhost:1998/test";
   return this._http.get(url);
 }

 getOneTest(testId:number):Observable<any>
 {
   let url = "http://localhost:1998/test/"+testId;
   return this._http.get(url);
 }

 getQuestionList(testId:number):Observable<any>
 {
   let url = "http://localhost:1998/question/list/"+testId;
   return this._http.get(url);
 }

 addQuestion(question:Question)
 {
    this.questions.push(question)
    alert(this.questions[1].questionId)
 }

 retrievQuest():Question[]
 {
  return this.questions;
 }

 getAllQuestion():Observable<any>
 {
   let url = "http://localhost:2022/question";
   return this._http.get(url);
 }

  setTest(test:Test)
  {
     this.test = test;
  }

  setQuestion(question:Question)
  {
    this.question = question;
  }

  getTest():Test
  {
    return this.test;
  }

 getQuestion():Question
 {
   return this.question;
 }

  deleteQuestion(id:number):Observable<any>
  {
   let url = "http://localhost:2022/question/delete/"+id;
   return this._http.delete(url, {responseType:'text'});
  }


  deleteTest(testId:number):Observable<any>
  {
    let url = "http://localhost:1998/test/delete/"+testId;
    return this._http.delete(url, {responseType:'text'});
  }

 updateQuestion(quest:Question):Observable<any>
 {
     let url= "http://localhost:1998/question/update";
     return this._http.put(url, quest, {responseType:'text'});
 }

 updateTest(test:Test):Observable<any>
 {
   let url = "http://localhost:1998/test/update";
   return this._http.put(url, test, {responseType:'text'});
 }

 assignTest(test):Observable<any>
 {
    let url = "http://localhost:1998/assign/test";
    return this._http.put(url, test, {responseType:'text'});
 }

questionCollection(question:Question)

{
  this.questions.push(question);
  alert(this.questions[1].questionTitle);
}

getResultList(userId:number):Observable<any>
{
  let url="http://localhost:2022/result/"+userId;
  return this._http.get(url);
}

addQuestionToTest(test:Test):Observable<any>
{
  let url ="http://localhost:1998/add/question/test";
  return this._http.put(url, test, {responseType:'text'});
}

addResult(result:Result)
 {
   let url = "http://localhost:1998/result/new";
   return this._http.post(url, result, {responseType:'text'});
 }

}

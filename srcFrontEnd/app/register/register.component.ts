import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { FetchService } from '../fetch.service';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

@ViewChild("#formdata")
form:NgForm;

  constructor(private service:FetchService) { }

  user:User = new User();

  ngOnInit(): void {
  }

createUser()
{

  alert(this.user.userName);
  this.service.createUser(this.user).subscribe(data=>
    {
      alert("user registerd successfully");
    }, 
    error=>
    {
      console.log("error occured", error);
      
    });
}

}

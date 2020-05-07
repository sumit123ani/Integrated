import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';
import { AuthenticationService } from '../authentication.service';
import { FetchService } from '../fetch.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

@ViewChild("#formdata")
form:NgForm;

  constructor(private service:AuthenticationService, private router:Router, private serv:FetchService) { }

 id:number;
 password:string;

 checkUser:User = new User();

 invalidLogin = false;

app:AppComponent;

  ngOnInit(): void {
    if(this.service.isUserLoggedIn())
     this.router.navigate(['']);
  }

 checkLogin(){
     
   this.serv.getUser(this.id).subscribe(data=>
    {
       this.checkUser = data;
       if(this.checkUser == null)
         alert("user does not exist");

       else{

        if(this.service.authenticate(this.password, this.checkUser))
        {
          alert("logged in")
          this.router.navigate([''])
          this.invalidLogin = false;
        }
        else
        {
          this.invalidLogin = true;
        }
     

       }  
    },
    error=>
    {
      console.log("error occured", error);
    });


 }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'OnlineTestManagement';
  userName:string;

  user:User = new User();

  constructor(private router:Router,public service:AuthenticationService){}

   flag:boolean = true;

ngOnInit():void{
   
  this.flag = true;
  if(!this.service.isUserLoggedIn())
  {
    this.router.navigateByUrl('/login');
  }
 else
 {
   this.router.navigate([''])
   this.user = this.service.getUser();
   this.userName = this.user.userName;

 }
   
}

logout()
{
  this.service.logout();
  this.flag = false;
  this.router.navigate(['/login']);
}

 changeFlag()
 {
   if(this.flag)
     this.flag = false;  
 }

 changeFlag1()
 {
   if(!this.flag)
     this.flag = true;
 }

}

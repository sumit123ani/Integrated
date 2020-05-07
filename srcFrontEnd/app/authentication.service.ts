import { Injectable } from '@angular/core';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  u:any;
   user:User;


  authenticate(password:string, checkUser:User)
  {

     if(checkUser.userPassword == password)
     { 
       sessionStorage.setItem('user', JSON.stringify(checkUser));
       return true;
     }
     else
     {
       alert("wrong password")
       return false;
     }

  }

  isUserLoggedIn()
  {
    let userr = JSON.parse(sessionStorage.getItem('user'));
    console.log(!(userr == null));
    return !(userr == null)
  
  }


  getUser():User
  {
    let user = JSON.parse(sessionStorage.getItem('user'))
    return user;
  }

  logout()
  {
    sessionStorage.removeItem('user');
  
  }

}

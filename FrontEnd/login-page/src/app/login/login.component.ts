import { registerLocaleData } from '@angular/common';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { User } from '../entity/user';
import { UserServiceService } from '../user-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation:ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
   user= new User();
  constructor(private _service : UserServiceService, private _router: Router) { }
    message="";
  ngOnInit(): void {
  }
  loginUser(){
      this._service.loginUserFromRemote(this.user).subscribe(
        data => {console.log("response received"),
             this._router.navigate(['/employees']);
      },
        error => {console.log("username or password is incorrect");
        this.message="username or password is incorrect";
      }
      )
  }
  onRegister(){
    this._router.navigate(['/users']);
  }
}

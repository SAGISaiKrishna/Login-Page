import { Component, ElementRef, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../entity/user';
import { UserServiceService } from '../user-service.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  encapsulation:ViewEncapsulation.None
})
export class RegisterComponent implements OnInit {
  user= new User();
  @ViewChild('username') userChild;
  constructor(private _service : UserServiceService,private _router: Router) { }
  message="";
  ngOnInit(): void {
  }
  registerUser(){
    this._service.registerUserFromRemote(this.user).subscribe(
      data => {console.log("user added"),
           this._router.navigate(['']);
    },
      error => {console.log("username is already taken");
      this.message="UserName is already taken";
    }
    )
}
print(){
  console.log(this.userChild)
}
  
}

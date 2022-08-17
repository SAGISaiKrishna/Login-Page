import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './entity/user';
import {HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private _http : HttpClient) { }

  public loginUserFromRemote(user :User):Observable<any>{
return this._http.post("http://localhost:8090/user",user)
  }
  public registerUserFromRemote(user :User):Observable<any>{
    return this._http.post("http://localhost:8090/users",user)
      }
  
}

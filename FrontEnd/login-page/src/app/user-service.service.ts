import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './entity/user';
import {HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private apiUrl = environment.apiUrl;

  constructor(private _http : HttpClient) { }

  public loginUserFromRemote(user :User):Observable<any>{
    return this._http.post(`${this.apiUrl}/user`,user)
  }
  public registerUserFromRemote(user :User):Observable<any>{
    return this._http.post(`${this.apiUrl}/users`,user)
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './entity/employee';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  private apiUrl = environment.apiUrl;

  constructor(private _http : HttpClient) { }

  public getEmployeesFromRemote():Observable<any>{
    return this._http.get<Employee[]>(`${this.apiUrl}/employees`)
      }
  public deleteEmployee(id: number): Observable<any> {
    return this._http.delete(`${this.apiUrl}/employees/`+id, { responseType: 'text' });
  }
  public addEmployeeFromRemote(employee: Employee): Observable<any> {
    return this._http.post(`${this.apiUrl}/employees/add`,employee);
  }
  public editEmployeeFromRemote(employee: Employee): Observable<any> {
    return this._http.put(`${this.apiUrl}/employees/edit`,employee);
  }
  public getLocationsFromRemote():Observable<any>{
    return this._http.get<{location:string[]}>(`${this.apiUrl}/locations`)
  }
  public getRolesFromRemote():Observable<any>{
    return this._http.get<{role:string[]}>(`${this.apiUrl}/roles`)
  }
  public getProductsFromRemote():Observable<any>{
    return this._http.get<{productTeam:string[]}>(`${this.apiUrl}/products`)
  }
  public getEmployeeById(id: number):Observable<any>{
    return this._http.get(`${this.apiUrl}/employ/`+id)
  }
  data: number;
  public setId(id: number){
    this.data=id;
  }
  public getId(){
    return this.data;
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './entity/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  constructor(private _http : HttpClient) { }

  public getEmployeesFromRemote():Observable<any>{
    return this._http.get<Employee[]>("http://localhost:8090/employees")
      }
  public deleteEmployee(id: number): Observable<any> {
    return this._http.delete("http://localhost:8090/employees/"+id, { responseType: 'text' });
  }
  public addEmployeeFromRemote(employee: Employee): Observable<any> {
    return this._http.post("http://localhost:8090/employees/add",employee);
  }
  public editEmployeeFromRemote(employee: Employee): Observable<any> {
    return this._http.put("http://localhost:8090/employees/edit",employee);
  }
  public getLocationsFromRemote():Observable<any>{
    return this._http.get<{location:string[]}>("http://localhost:8090/locations")
  }
  public getRolesFromRemote():Observable<any>{
    return this._http.get<{role:string[]}>("http://localhost:8090/roles")
  }
  public getProductsFromRemote():Observable<any>{
    return this._http.get<{productTeam:string[]}>("http://localhost:8090/products")
  }
  public getEmployeeById(id: number):Observable<any>{
    return this._http.get("http://localhost:8090/employ/"+id)
  }
  data: number;
  public setId(id: number){
    this.data=id;
  }
  public getId(){
    return this.data;
  }
}

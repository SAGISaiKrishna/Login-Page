import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EmployeeServiceService } from 'src/app/employee-service.service';
import { Employee } from 'src/app/entity/employee';
import { MatTableDataSource } from '@angular/material/table';
interface Employ{
  firstName:string;
  lastName:string;
  email:string;
  roleName:string;
  productName:string;
  locationName:string;
  active:string;
  empId:number;
}
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  constructor(private _service : EmployeeServiceService, private _router: Router) { }
  displayedColumns: string[] = ['no','firstname', 'lastname', 'employeeEmail','role','product','location','active','action'];
  
  ngOnInit(){
    this.reloadData();
  }

  dataSource = new MatTableDataSource<Employ>();
   employees: Observable<Employee[]>;
  reloadData() {
    this._service.getEmployeesFromRemote().subscribe(
data=> {this.employees=data;
         this.dataSource.data= data.map((tmp:Employee)=>this.employeeMapper(tmp))
         console.log(this.dataSource.data);}
    );
   
    // this.employees.forEach ((res=> {this.dataSource.data=res as Employee})); 
    
  }
  deleteEmployee(empId: number) {
    console.log(empId);
    this._service.deleteEmployee(empId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  onEditEmployee(id: number){
    this._service.setId(id);
    this._router.navigate(['/employees/edit']);
  }
  onCreateEmployee(){
    this._router.navigate(['/employees/add']);
  }
  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }
  private employeeMapper(data:Employee):Employ
  {
    return {
      empId:data.empId,
      firstName:data.firstname,
      lastName:data.lastname,
      email:data.employeeEmail,
      locationName:data.location.locationName,
      roleName:data.role.roleName,
      productName:data.productTeam.productName,
      active:data.active
    }
  }
}

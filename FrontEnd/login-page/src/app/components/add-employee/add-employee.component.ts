import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EmployeeServiceService } from 'src/app/employee-service.service';
import { Address } from 'src/app/entity/address';
import { Employee } from 'src/app/entity/employee';
import { Location } from 'src/app/entity/location';
import { ProductTeam } from 'src/app/entity/product-team';
import { Role } from 'src/app/entity/role';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private _service : EmployeeServiceService, private _router: Router) { }
employee= new Employee();
address= new Address();
product= new ProductTeam();
location=new Location();
role=new Role();
roles: string[]=[];
products: string[]=[];
locations: string[]=[];

addEmployee(){
this.employee.role=this.role;
this.employee.productTeam=this.product;
this.employee.location=this.location;
this.employee.address=this.address;
this._service.addEmployeeFromRemote(this.employee).subscribe(
  data => {console.log("employee added"),
       this._router.navigate(['/employees']);
},
  error => {console.log("error in employee");
})
}
  ngOnInit(): void {
   this._service.getLocationsFromRemote().subscribe(
    (data)=>{
      this.locations=data.location;
      console.log("locations obtained")
      
    },
    (error)=>{
      console.log("error in location")
    }
   );
   this._service.getRolesFromRemote().subscribe(
    (data)=>{
      this.roles=data.role;
      console.log("roles obtained")
      console.log(this.roles);
    },
    (error)=>{
      console.log("error in roles")
    }
   );
   this._service.getProductsFromRemote().subscribe(
    (data)=>{
      this.products=data.productTeam;
      console.log("products obtained")
    },
    (error)=>{
      console.log("error in products")
    }
   );
  }

}

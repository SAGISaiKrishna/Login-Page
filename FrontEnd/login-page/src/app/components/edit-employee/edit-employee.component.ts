import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeServiceService } from 'src/app/employee-service.service';
import { Address } from 'src/app/entity/address';
import { Employee } from 'src/app/entity/employee';
import { Location } from 'src/app/entity/location';
import { ProductTeam } from 'src/app/entity/product-team';
import { Role } from 'src/app/entity/role';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  employee1=new Employee();
  constructor(private _service : EmployeeServiceService, private _router: Router) { }
  employee= new Employee();
  address= new Address();
  product= new ProductTeam();
  location=new Location();
  role=new Role();
  roles: string[]=[];
  products: string[]=[];
  locations: string[]=[];
   id: number;
  editEmployee(){
   this.employee.role.roleName=this.role.roleName;
   this.employee.productTeam=this.product;
   this.employee.location=this.location;
   this.employee.address=this.address;
   
   this._service.editEmployeeFromRemote(this.employee).subscribe(
  data => {console.log(this.employee.productTeam.productName);
    console.log("employee edited"),
       this._router.navigate(['/employees']);
},
  error => {console.log("error in editemployee");
})
  }
  ngOnInit(): void {
this.id=this._service.getId();
this._service.getEmployeeById(this.id).subscribe(
  (data)=>{
      console.log(data);
       this.employee1=data;
       this.employee=this.employee1;
       this.address=this.employee1.address;
       this.role=this.employee1.role;
       this.location=this.employee1.location;
       this.product=this.employee1.productTeam;

},
(error)=>{
  console.log("error in getemployeebyid");
})
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

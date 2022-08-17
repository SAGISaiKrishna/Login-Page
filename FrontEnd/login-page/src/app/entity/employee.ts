import { Address } from "./address";
import { Location } from "./location";
import { ProductTeam } from "./product-team";
import { Role } from "./role";


export class Employee{
    empId:number;
    firstname:string;
    lastname:string;
    employeeEmail:string;
    address:Address;
    location:Location;
    productTeam:ProductTeam;
    role:Role;
    active:string;
}
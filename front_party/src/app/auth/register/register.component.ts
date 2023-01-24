import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  person :any = {
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    address: '',
    city: '',
    nombreDA: '',
    password: ''
  }

  constructor(private http: HttpClient,private router:Router) {}

  createPerson() {
    this.http.post('http://localhost:8080/person/add', this.person).subscribe(data => {
      console.log(data);
      this.router.navigate(['/login']);

    });
  }


}

import {Component, EventEmitter, Output} from '@angular/core';
import {User} from "../../core/interfaces/user";
import {AuthService} from "../../core/services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  // user : User = new User();
  loginEmail: string = '';
  loginPassword: string = '';
  // @Output() authEmitter: EventEmitter<User> = new EventEmitter();

  constructor(private authService: AuthService,private router: Router) { }


  login() {
      console.log("onSubmit");
      const user: User = {
      "email" : this.loginEmail,
      "password" : this.loginPassword
      }
    this.authService.login(user);
  }


}

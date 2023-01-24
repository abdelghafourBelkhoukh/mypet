import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../interfaces/user";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiRoot: string ='http://localhost:8080/auth'
  loggedIn: boolean = false;
  localToken: boolean = localStorage.getItem('token')?true:false;
  token : string = localStorage.getItem('token')?localStorage.getItem('token')||'null':"";
  user: any = localStorage.getItem('user')?JSON.parse(localStorage.getItem('user') || "null"):null;


    constructor(private http: HttpClient,private route:Router) { }

    public login(authRequest: User): void {
      this.http.post<any>(`${this.apiRoot}`+"/login",authRequest).subscribe(data=>{
        this.loggedIn = true;
        localStorage.setItem('token',data.token);
        localStorage.setItem('user',JSON.stringify(data.user));
        this.localToken = true;
        this.user = data.user;
        this.route.navigate(['/posts']);
      });
    }


  logout() {
    this.loggedIn = false;
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    this.localToken = false;
    this.route.navigate(['/posts']);
  }
}

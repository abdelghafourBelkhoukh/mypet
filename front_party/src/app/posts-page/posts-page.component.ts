import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {AuthService} from "../core/services/auth.service";

@Component({
  selector: 'app-posts-page',
  templateUrl: './posts-page.component.html',
  styleUrls: ['./posts-page.component.css']
})
export class PostsPageComponent {

  posts: any = [];
  animals: any = [];

  popUpAnimal: boolean = false;
  popUpAnnouncement: boolean = false;

  currentDateTime: Date = new Date();
  announcement: any = {
    title:"",
    description:"",
    date: this.currentDateTime.toLocaleDateString() +" " + this.currentDateTime.toLocaleTimeString(),
    ndj:2,
    animal_id:"",
    person_id: ""
  }

  dataComment: any = {
    comment:"",
    date: this.currentDateTime.toLocaleDateString() +" " + this.currentDateTime.toLocaleTimeString(),
    announcement_id:"",
    person_id: ""
  }

  animal: any = {
    name:"",
    age:"",
    type:"",
    image:"",
    person_id: ""
  }

constructor(private http: HttpClient,public authService:AuthService) {}

ngOnInit(): void {

  this.http.get('http://localhost:8080/announcement/all').subscribe(data => {
    this.posts = data;
  });
  this.http.get('http://localhost:8080/animal/all').subscribe(data => {
    this.animals = data;
  });
}

  createAnnouncement(): void {
      console.log(this.announcement);
      this.announcement.person_id = this.authService.user.id;
    this.http.post('http://localhost:8080/announcement/add', this.announcement, { headers: { Authorization: 'Bearer ' + this.authService.token } }).subscribe(data => {
      this.posts.push(data);
    });
  }

  createAnimal(): void {
    this.animal.person_id = this.authService.user.id;
    console.log({Authorization: 'Bearer ' + this.authService.token});
    this.http.post('http://localhost:8080/animal/add', this.animal,{ headers: { Authorization: 'Bearer ' + this.authService.token } }).subscribe(data => {
      this.animals.push(data);
    });
  }

  onFileSelected(event: any): void {
    this.animal.image = event.target.files[0].name;
  }

  createComment(announcement_id: number): void {
    this.dataComment.person_id = this.authService.user.id;
    this.dataComment.announcement_id = announcement_id;
    console.log({Authorization: 'Bearer ' + this.authService.token});
    this.http.post('http://localhost:8080/comment/add', this.dataComment, { headers: { Authorization: 'Bearer ' + this.authService.token } }).subscribe(data => {
      this.dataComment.comment = "";
      this.posts.filter((post: any) => {
        if (post.id === this.dataComment.announcement_id) {
          post.comments.push(data);
        }
      });
    });
  }

  openAnimalPopUp(): void {
    console.log("openAnimalPopUp");
    this.popUpAnimal = !this.popUpAnimal;
  }

  openPostPopUp(): void {
    console.log("openPostPopUp");
    this.popUpAnnouncement = !this.popUpAnnouncement;
  }

}

import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  standalone: false,

  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  name = 'bessem';
  location='tunisina';
  status='actif';

  constructor(private router: Router) {}



  getStatus(){
    return this.status;
  }

  getMessage(){
    console.log("message")
  }
  goToregister(){
   this.router.navigate(["/register"])
  }
}

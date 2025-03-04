import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: false,

  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
 name="bessem";
  active=true;
dataList= [
  {name:"bessem" , code:156, country:"tunisia"},
  {name:"hassoun" , code:186, country:"ariana"}

]
nom="hassen";
constructor(private route : Router) {}


goToUser(){
  this.route.navigate(["/user"]);
}

}

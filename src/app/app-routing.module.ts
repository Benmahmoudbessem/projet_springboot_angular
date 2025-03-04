import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { ProductsComponent } from './products/products.component';

const routes: Routes = [
  {path: "user" ,component:UserComponent},
  {path: "register" ,component:RegisterComponent},
  {path: "product" ,component:ProductsComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

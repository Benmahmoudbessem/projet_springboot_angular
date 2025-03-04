import { Component } from '@angular/core';
import { ProductServiceService } from '../services/product-service.service';

@Component({
  selector: 'app-products',
  standalone: false,

  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  products= [];

  constructor(private productService: ProductServiceService){}
  ngOnInit(): void{
   

  }



}



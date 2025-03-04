import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  productTable= [
    {productName: "orange", productPrice:"20", productQuantity:5},
    {productName: "apple", productPrice:"30", productQuantity:5},
    {productName: "banana", productPrice:"50", productQuantity:5}

  ]



  constructor() { }
}

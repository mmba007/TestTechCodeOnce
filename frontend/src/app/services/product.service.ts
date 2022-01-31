import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL } from '../app.constants';
import { ProductListComponent } from '../product-list/product-list.component';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  constructor(private httpClient:HttpClient,
    ) { 
  }


    // fetch products
    getProducts(): Observable<any[]> {
return this.httpClient.get<any[]>(`${API_URL}/products`);
      // return this.cdaClient.getEntries(Object.assign({
      //   content_type: DEFAULT_CONFIG.contentTypeIds.product
      // }, query))
      // .then(res => res.items);
    }
  
    // // fetch products with a given slug
    // // and return one of them
    getProductById(productId: string): Observable<any> {
      console.log("product Id is: ",productId)
      return this.httpClient.get<any[]>(`${API_URL}/products/${productId}`);
      // return this.getProducts({ 'fields.slug': slug })
      // .then(items => items[0])
    }
  
    // fetch categories
    getCategories(): Observable<any[]> {
      return this.httpClient.get<any[]>(`${API_URL}/categories`);
      // return this.cdaClient.getEntries({
      //   content_type: DEFAULT_CONFIG.contentTypeIds.category
      // })
      // .then(res => res.items);
    }

    searchProductsByCategory(categName:string): Observable<any> {
      return this.httpClient.get<any[]>(`${API_URL}/products/category/${categName}`);
    }

}

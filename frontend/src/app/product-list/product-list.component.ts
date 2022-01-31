import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { MatPaginator } from '@angular/material';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: any[];
  categories:any[];

  constructor(private productService: ProductService) { }

  myControl = new FormControl();
  categsNames: string[] = [];
  filteredCategs: Observable<string[]>;

  // @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.productService.getCategories()
    .subscribe(data=>{
      console.log(data);
      this.categories=data;
      this.categsNames=[];
      this.categories.forEach(c=>{
        this.categsNames.push(c.name);
      })
    });

    this.filteredCategs = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  searchByCategory(){
    if(this.myControl && this.myControl.value){
      this.productService.searchInStockProductsByCategory(this.myControl.value)
      .subscribe(data=>{
        console.log(data);
        this.products=data;
      });
    }else{
      this.products=[];
    }
   
  }

  handlekeypressEvent($event) {
    console.log($event);
  }
    
    private _filter(value: string): string[] {
      const filterValue = value.toLowerCase();
  
      return this.categsNames.filter(categ => categ.toLowerCase().includes(filterValue));
    }
}

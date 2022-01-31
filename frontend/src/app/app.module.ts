import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';
import { RouterModule, Routes }   from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatListModule, MatInputModule, MatToolbarModule, MatButtonModule, MatCardModule, MatTabsModule, MatTableModule, MatAutocomplete, MatSortModule, MatPaginatorModule, MatFormFieldModule, MatAutocompleteModule } from '@angular/material';

import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';

import { HttpClientModule } from '@angular/common/http';

// check this and make a module out of it
const routes: Routes = [
  { path: '', redirectTo: '/products', pathMatch: 'full' },
  { path: 'products',  component: ProductListComponent },
  { path: 'products/:productId', component: ProductDetailComponent },

];

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductDetailComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes, { useHash: true }),
    FormsModule,
    MatListModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatTabsModule,
    MatInputModule,  
    MatAutocompleteModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatFormFieldModule,
    HttpClientModule
  ],
  exports: [
    MatListModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatTabsModule,
    MatInputModule,
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CategorySelectionComponent} from './components/category-selection/category-selection.component';
import {CategoriesService} from './services/categories.service';
import {BooksByCategoryService} from './services/books-by-category.service';

@NgModule({
  declarations: [
    AppComponent,
    CategorySelectionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [CategoriesService, BooksByCategoryService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

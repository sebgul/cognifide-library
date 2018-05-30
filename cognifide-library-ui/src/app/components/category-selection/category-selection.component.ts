import {Component, OnInit} from '@angular/core';
import {CategoriesService} from '../../services/categories.service';
import {BooksByCategoryService} from '../../services/books-by-category.service';

@Component({
  selector: 'app-category-selection',
  templateUrl: './category-selection.component.html',
  styleUrls: ['./category-selection.component.css']
})
export class CategorySelectionComponent implements OnInit {

  public categories;
  public books;

  constructor(private categoriesService: CategoriesService, private booksByCategoryService: BooksByCategoryService) {
  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this.categoriesService.getCategories().subscribe(
      data => {
        this.categories = data;
      },
      err => console.error(err),
      () => console.log('categories loaded')
    );
  }

  getBooksByCategory(event: Event) {
    this.booksByCategoryService.getBooksByCategory((<HTMLSelectElement>(event.target)).value).subscribe(
      data => {
        this.books = data;
      },
      err => console.error(err),
      () => console.log('books loaded')
    );
  }
}

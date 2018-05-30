import {Component, OnInit} from '@angular/core';
import {CategoriesService} from '../../services/categories.service';

@Component({
  selector: 'app-category-selection',
  templateUrl: './category-selection.component.html',
  styleUrls: ['./category-selection.component.css']
})
export class CategorySelectionComponent implements OnInit {

  public categories;

  constructor(private categoriesService: CategoriesService) {
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
}

import { TestBed, inject } from '@angular/core/testing';

import { BooksByCategoryService } from './books-by-category.service';

describe('BooksByCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BooksByCategoryService]
    });
  });

  it('should be created', inject([BooksByCategoryService], (service: BooksByCategoryService) => {
    expect(service).toBeTruthy();
  }));
});

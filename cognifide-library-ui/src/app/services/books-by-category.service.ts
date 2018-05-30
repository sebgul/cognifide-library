import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BooksByCategoryService {

  constructor(private http: HttpClient) {
  }

  getBooksByCategory(category: String) {
    return this.http.get('/server/api/category/' + category + '/books');
  }
}

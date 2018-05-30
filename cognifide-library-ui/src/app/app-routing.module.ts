import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CategorySelectionComponent} from './components/category-selection/category-selection.component';

const routes: Routes = [
  {
    path: '',
    component: CategorySelectionComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

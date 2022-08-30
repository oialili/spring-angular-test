import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Router, RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { ArticleListComponent } from './article/article-list/article-list.component';
import { OrderListComponent } from './order/order-list/order-list.component';
import { OrderCreateComponent } from './order/order-create/order-create.component';
import { ArticleCreateComponent } from './article/article-create/article-create.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthentificationComponent } from './authentification/authentification.component';
import { HttpClientModule } from '@angular/common/http';
import { OrderEditComponent } from './order/order-edit/order-edit.component';

const routes: Routes = [
  {path: 'articles', component: ArticleListComponent},
  {path: 'orders', component: OrderListComponent},
  {path: 'articles/add', component: ArticleCreateComponent},
  {path: 'orders/add', component: OrderCreateComponent},
  {path: 'orders/edit', component: OrderEditComponent},
  {path:"",redirectTo:"login",pathMatch:"full"},
  {path:"login",component:AuthentificationComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    ArticleListComponent,
    OrderListComponent,
    OrderCreateComponent,
    ArticleCreateComponent,
    AuthentificationComponent,
    OrderEditComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

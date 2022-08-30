import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from './order';
import { Observable } from 'rxjs';
import { Article } from '../article/article';


const ROUTE_ORDER = environment.baseURL + '/orders';
const ROUTE_ARTICLE= environment.baseURL + '/articles';
const username = environment.username
const password = environment.password

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  constructor(private http: HttpClient) { }

  createOrder(order: Order){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.post<Order>(ROUTE_ORDER, order, {headers});
  }

  updateOrder(order: Order){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.put<Order>(ROUTE_ORDER, order, {headers});
  }

  getOrders(): Observable<Order[]> {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get<Order[]>(ROUTE_ORDER,{headers});
  }

  getArticles() {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get<Article[]>(ROUTE_ARTICLE, {headers});
  }
  
}

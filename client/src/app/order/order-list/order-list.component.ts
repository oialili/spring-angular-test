import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/article/article';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  orders: Order[] = [];
  orderById: Order[] = [];
  articles: Article[] = [];

  constructor(private orderService: OrderService, private router: Router) { }

  ngOnInit(): void {
    this.orderService.getOrders().subscribe(data => {
      this.orders = data;
    });

    this.orderService.getArticles().subscribe(data => {
      this.articles = data;
    });
  }

  editOrder(id: any) {

    

    this.orderById = [];
    this.orders.forEach((order) => {
      if(order.id === id){
        this.router.navigateByUrl('orders/edit', { state: { selectedOrder: order } });
      }
    });
  }

}

import { Component, Injector, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Article } from 'src/app/article/article';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-create',
  templateUrl: './order-create.component.html',
  styleUrls: ['./order-create.component.css']
})
export class OrderCreateComponent implements OnInit {
  orders: Order[] = [];
  articles: Article[] = [];

  constructor(private orderService: OrderService, private formBuilder: FormBuilder, private router: Router) { }

  myFormGroup: FormGroup= this.formBuilder.group({
    article: [''],
    reference: [''],
    date: [''],
  });

  ngOnInit(): void {
    this.orderService.getArticles().subscribe(data => {
      this.articles = data;
    });
  }

  addOrder() {
    var order: Order = {};
    order.articles = [];
    let articleIds = this.myFormGroup.get('article')!.value;

    this.articles.forEach((article) => {
      if(articleIds.indexOf(article.id?.toString()) > -1){
        order.articles?.push(article);
      }
    });
    order.reference = this.myFormGroup.get('reference')!.value;
    order.date = this.myFormGroup.get('date')!.value;
    this.orderService.createOrder(order).subscribe(data => {
      order = data
      this.router.navigate(['/orders']);
    });    
  }

  

}

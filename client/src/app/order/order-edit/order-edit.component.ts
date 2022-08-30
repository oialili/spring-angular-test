import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Article } from 'src/app/article/article';
import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-edit',
  templateUrl: './order-edit.component.html',
  styleUrls: ['./order-edit.component.css']
})
export class OrderEditComponent implements OnInit {
  editedOrder: Order = {};
  articles: Article[] = [];

  constructor(private orderService: OrderService, private formBuilder: FormBuilder, public activatedRoute: ActivatedRoute, private router: Router) { }

  myFormGroup: FormGroup= this.formBuilder.group({
    id: 0,
    article: [],
    reference: "",
    date: "",
  });

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
     this.editedOrder = window.history.state.selectedOrder;
    });
    
    this.orderService.getArticles().subscribe(data => {
      this.articles = data;
    });

    this.myFormGroup.get('reference')?.setValue(this.editedOrder.reference);
    this.myFormGroup.get('date')?.setValue(this.editedOrder.date);
  }

  editOrder() {
    var order: Order = {};
    order.articles = [];
    let articleIds = this.myFormGroup.get('article')!.value;
    this.articles.forEach((article) => {
      if(articleIds.indexOf(article.id?.toString()) > -1){
        order.articles?.push(article);
      }
    });
    order.id = this.editedOrder.id;
    order.reference = this.myFormGroup.get('reference')!.value;
    order.date = this.myFormGroup.get('date')!.value;
    this.orderService.updateOrder(order).subscribe(data => {
      order = data
      this.router.navigate(['/orders']);
    });   
  }

}

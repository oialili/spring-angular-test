import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Article } from './article';


const ROUTE_ARTICLE = environment.baseURL + '/articles';
const username = environment.username
const password = environment.password

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient) { }


  createArticle(article: Article){
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.post<Article>(ROUTE_ARTICLE, article, {headers});
  }

  getArticles() {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get<Article[]>(ROUTE_ARTICLE, {headers});
  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Article } from '../article';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-article-create',
  templateUrl: './article-create.component.html',
  styleUrls: ['./article-create.component.css']
})
export class ArticleCreateComponent implements OnInit {
  articles: Article[] = [];
  imgFile: any;
  public imagePath: any;
  imgURL: any;
  public message!: string 

  constructor(private articleService: ArticleService, private formBuilder: FormBuilder, private router: Router) { }

  myFormGroup: FormGroup = this.formBuilder.group({
    name: [''],
    price: [''],
    picture: ['']
  });

  ngOnInit(): void {
  }

  createArticle() {
    var article: Article = {};
    article.name = this.myFormGroup.get('name')!.value;
    article.price = this.myFormGroup.get('price')!.value;
    article.picture = this.imgFile.name;
    this.articleService.createArticle(article).subscribe(data => {
      article = data
      this.router.navigate(['/articles']);
    });
  }

  onSelectFile(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.imgFile = file;
      var mimeType = event.target.files[0].type;
      if (mimeType.match(/image\/*/) == null) {
        this.message = "Only images are supported.";
        return;
      }
      var reader = new FileReader();
      this.imagePath = file;
      reader.readAsDataURL(file);
      reader.onload = (_event) => {
        this.imgURL = reader.result;
      }
    }
  }

}

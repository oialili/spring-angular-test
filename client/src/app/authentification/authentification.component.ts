import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from './authentification.service';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {
  username!: string;
  password!: string;
  message: any

  constructor(private authentificationService: AuthentificationService, private router:Router) { }

  ngOnInit(): void {
  }

  doLogin() {
    let resp = this.authentificationService.login(this.username, this.password);
    resp.subscribe(data => {
      this.message = data;
     this.router.navigate(["/articles"])
    });
  }

}

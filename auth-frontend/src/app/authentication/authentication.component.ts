import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from './authentication.service';
import { AuthFeedback } from './authfeedback-model';
import { Response } from '@angular/http';

import 'rxjs/add/operator/map';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  authFeedback: AuthFeedback;

  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit() {
  }

  login(loginForm: NgForm) {
    this.authService.login(loginForm.value.username, loginForm.value.password)
    .map((res: Response) => this.authFeedback = res.json())
    .subscribe( ()  => {
      localStorage.setItem('user', this.authFeedback.user);
      localStorage.setItem('token', this.authFeedback.token);
      console.log(this.authFeedback);
    });
    this.router.navigate(['/welcome']);
  }

}

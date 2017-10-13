import { Component, OnInit } from '@angular/core';
import { JwtHelper } from 'angular2-jwt';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }
}

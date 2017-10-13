import {Inject, Injectable} from '@angular/core';
import {Http} from '@angular/http';

import { tokenNotExpired } from 'angular2-jwt';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) {}

  login(username: string, password: string) {
  return this.http.post('http://localhost:8080/login', {username: username, password: password});

  }

  loggedIn() {
    return tokenNotExpired();
  }
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AuthenticationComponent } from './authentication/authentication.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MdInputModule } from '@angular/material';
import { MdFormFieldModule } from '@angular/material';
import {MdButtonModule} from '@angular/material';
import {MdMenuModule} from '@angular/material';


import { AuthenticationService } from './authentication/authentication.service';
import { AuthGuard } from './authentication/auth-guard.service';

import { WelcomeComponent } from './welcome/welcome.component';

import { AuthenticationModule } from './authentication/authentication.module';

const ROUTES = [{path: 'login', component: AuthenticationComponent},
                {path: 'welcome', component: WelcomeComponent },
              ];

@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
    WelcomeComponent,
  ],
  imports: [
    RouterModule.forRoot(ROUTES),
    AuthenticationModule,
    BrowserModule,
    FormsModule,
    HttpModule,
    BrowserAnimationsModule,
    MdInputModule,
    MdButtonModule,
    MdMenuModule
  ],
  providers: [AuthenticationService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

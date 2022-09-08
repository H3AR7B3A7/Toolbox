import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { MatButtonModule } from "@angular/material/button";

@NgModule({
  declarations: [NavBarComponent],
  imports: [
    CommonModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule
  ],
  exports: [AppRoutingModule, NavBarComponent, BrowserAnimationsModule]
})
export class CoreModule {}

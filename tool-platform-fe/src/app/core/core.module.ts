import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { CommonModule } from '@angular/common';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [NavBarComponent],
  imports: [CommonModule, AppRoutingModule, BrowserAnimationsModule],
  exports: [AppRoutingModule, NavBarComponent, BrowserAnimationsModule]
})
export class CoreModule {}

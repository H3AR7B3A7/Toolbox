import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from '@app/app.component';
import { HomeComponent } from '@app/home/home.component';
import { CoreModule } from '@app/core/core.module';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, LoginComponent],
  imports: [BrowserModule, CoreModule],
  bootstrap: [AppComponent]
})
export class AppModule {}

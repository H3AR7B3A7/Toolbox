import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from '@app/app.component';
import { HomeComponent } from '@app/home/home.component';
import { CoreModule } from '@app/core/core.module';

@NgModule({
  declarations: [AppComponent, HomeComponent],
  imports: [BrowserModule, CoreModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}

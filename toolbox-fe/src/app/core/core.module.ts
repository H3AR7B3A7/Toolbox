import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SharedModule } from '@app/shared/shared.module';

@NgModule({
    declarations: [NavBarComponent],
    imports: [CommonModule, AppRoutingModule, HttpClientModule, SharedModule],
    exports: [AppRoutingModule, NavBarComponent, SharedModule]
})
export class CoreModule {}

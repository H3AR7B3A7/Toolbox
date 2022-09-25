import { Component, OnInit } from '@angular/core';
import { Observable, pluck } from 'rxjs';

import { TelemetryService } from '../core/telemetry.service';

@Component({
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
    appStatus$?: Observable<'UP' | 'DOWN'>;
    userCount$?: Observable<number>;

    constructor(private metrics: TelemetryService) {}

    ngOnInit(): void {
        this.userCount$ = this.metrics.getUserMetrics().pipe(pluck('users'));
        this.appStatus$ = this.metrics.getHealthMetrics().pipe(pluck('status'));
    }
}

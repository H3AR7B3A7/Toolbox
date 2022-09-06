import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { HealthMetrics } from './health-metrics';
import { UserMetrics } from './user-metrics';

@Injectable({
  providedIn: 'root'
})
export class TelemetryService {
  private static readonly HEALTH_ENDPOINT = environment.telemetryUrl + 'health';
  private static readonly USERS_ENDPOINT = environment.telemetryUrl + 'users';

  constructor(private http: HttpClient) {}

  public getHealthMetrics() {
    return this.http.get<HealthMetrics>(TelemetryService.HEALTH_ENDPOINT);
  }

  public getUserMetrics() {
    return this.http.get<UserMetrics>(TelemetryService.USERS_ENDPOINT);
  }
}

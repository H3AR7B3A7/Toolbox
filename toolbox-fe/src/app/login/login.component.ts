import { Component } from '@angular/core';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  login() {
    window.location.href = environment.apiUrl + 'oauth2/authorization/google';
  }
}

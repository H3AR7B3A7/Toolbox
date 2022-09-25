import { Component } from '@angular/core';
import { environment } from '../../environments/environment';

@Component({
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent {
    googleLogin() {
        window.location.href =
            environment.apiUrl + 'oauth2/authorization/google';
    }
}

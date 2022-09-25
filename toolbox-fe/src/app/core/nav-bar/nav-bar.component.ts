import { Component, OnInit } from '@angular/core';
import { AuthService } from '@app/core/auth.service';
import { map, Observable, startWith } from 'rxjs';

/**
 * The navigation bar at the top of the page
 */
@Component({
    selector: 'nav-bar',
    templateUrl: './nav-bar.component.html',
    styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
    loggedIn!: Observable<boolean>;
    picture!: Observable<string | undefined>;

    constructor(private authService: AuthService) {}

    /**
     * Checks for authentication and fetches the user profile picture
     */
    ngOnInit(): void {
        this.loggedIn = this.authService.isLoggedIn;
        this.picture = this.authService.auth.pipe(
            startWith(undefined),
            map((auth) => auth?.picture)
        );
    }

    /**
     * Called by the logout button
     */
    logout() {
        this.authService.logout();
    }
}

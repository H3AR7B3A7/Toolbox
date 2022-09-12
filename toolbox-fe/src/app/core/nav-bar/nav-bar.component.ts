import { Component, OnInit } from '@angular/core';
import { AuthService } from '@app/core/auth.service';
import { map, Observable, startWith } from 'rxjs';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  loggedIn!: Observable<boolean>;
  picture!: Observable<string | undefined>;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.loggedIn = this.authService.isLoggedIn;
    this.picture = this.authService.auth.pipe(
      startWith(undefined),
      map((auth) => auth?.picture)
    );
  }

  logout() {
    this.authService.logout();
  }
}

import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Auth } from '@app/core/auth';
import { BehaviorSubject, map, Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    private _auth = new BehaviorSubject<Auth | undefined>(undefined);

    constructor(private http: HttpClient) {}

    get auth(): Observable<Auth | undefined> {
        return this._auth.asObservable();
    }

    get isLoggedIn(): Observable<boolean> {
        return this.auth.pipe(map((auth) => auth !== undefined));
    }

    checkAuth() {
        this.http.get<Auth>(environment.apiUrl + 'auth').subscribe((auth) => {
            this._auth.next(auth);
        });
    }

    logout() {
        this._auth.next(undefined);
        window.location.href = environment.apiUrl + 'logout';
    }
}

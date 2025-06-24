import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../constants';
import { Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  getRoleFromToken() {
      // @ts-ignore
    return this.getDecodedToken()?.role || '';
  }

  isTokenExpired(): boolean {
    const decodedToken = this.getDecodedToken();

    // @ts-ignore
    if (!decodedToken || !decodedToken.exp) {
      return true; // Considerăm expirat dacă nu putem decoda
    }

    // @ts-ignore
    const expiryTime = decodedToken.exp * 1000; // `exp` este în secunde
    return expiryTime < Date.now();
  }

  logout() {
      localStorage.removeItem('authToken');
      console.log("Am facut logout");
  }

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {
    return this.http.post<{ token: string }>(`${SERVER_API_URL}/auth/login`, { email, password }).pipe(
      tap(response => {
        console.log("Am primit raspunsul", response);
        localStorage.setItem('authToken', response.token);
      })
    );
  }

  register(userData: any): Observable<any> {
    return this.http.post(`${SERVER_API_URL}/auth/register`, userData);
  }

  // recoverPassword(email: string): Observable<any> {
  //   return this.http.post(`${SERVER_API_URL}/recover-password`, { email });
  // }

  resetPassword(email: string, newPassword: string): Observable<any> {
    return this.http.post(`${SERVER_API_URL}/auth/reset-password`, { email, newPassword });
  }


  getDecodedToken(): Object {
    try {
      return jwtDecode(localStorage.getItem('authToken') || '') || {};
    }
    catch (e) {
      console.log("Nu ai token!")
      return {}
    }
  }
  getCurrentUserId(): number | null {
    const userJson = localStorage.getItem('user'); // sau sessionStorage.getItem(...)
    if (userJson) {
      const user = JSON.parse(userJson);
      return user.id; // sau user.userId, în funcție de ce ai salvat
    }
    return null;
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('user');
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from '../constants';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  users:{
    id: number,
    username: string,
    firstname: string,
    lastname: string,
    email: string,
    role: string,
    phone: string,
    validated: boolean
  }[] = [];

  getUserById(userId: string) {
    return this.http.get(`${SERVER_API_URL}/users/${userId}`);
  }

  updateUser(userId: any, user: any) {
    return this.http.put(`${SERVER_API_URL}/users/${userId}`, user);
  }

  deleteUser(userId: string) {
    return this.http.delete(`${SERVER_API_URL}/users/${userId}`);
  }

  constructor(private http: HttpClient) { }

  getUsers(): Observable<any> {
    return this.http.get(`${SERVER_API_URL}/users`);
  }

  addUser(user: any): Observable<any> {
    return this.http.post(`${SERVER_API_URL}/users`, user);
  }
}

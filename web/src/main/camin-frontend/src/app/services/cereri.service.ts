import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {SERVER_API_URL} from '../constants';
import {Cerere} from './cerere.model';

@Injectable({
  providedIn: 'root'
})
export class CereriService {
  cereri:{
    id: string,
    subiect: string,
    descriere: string,
    data: string,
    status: 'PENDING' | 'APPROVED' | 'REJECTED' |  'DONE';
  }[] = [];

  constructor(private http: HttpClient) {
  }

  getCerereById(cerereId: string) {
    return this.http.get(`${SERVER_API_URL}/cereri/${cerereId}`);
  }
  getCereri(): Observable<any> {
    return this.http.get(`${SERVER_API_URL}/cereri`);
  }

  addCereri (cerere: any): Observable<any> {
    return this.http.post(`${SERVER_API_URL}/cereri`, cerere);
  }

  updateCerere(cerereId: any, cerere: any) {
    return this.http.put(`${SERVER_API_URL}/cereri/${cerereId}`, cerere);
  }

  deleteCerere(cerereId: string) {
    return this.http.delete(`${SERVER_API_URL}/cereri/${cerereId}`);
  }


  getCereriByUserId(userId: number): Observable<Cerere[]> {
    return this.http.get<Cerere[]>(`${SERVER_API_URL}/cereri/${userId}`);
  }

}

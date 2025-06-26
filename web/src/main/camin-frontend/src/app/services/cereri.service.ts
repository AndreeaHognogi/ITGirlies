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

// Obține cererile aprobate pentru angajat
  getCereriAprobate() {
    return this.http.get<{id:string, subiect:string, descriere:string, data:string, status: string}[]>('/cereri/aprobate');
  }

// Actualizează statusul cererii (ex: DONE)
  updateStatusCerere(cerereId: string, status: string) {
    return this.http.put(`/cereri/${cerereId}/status`, {status});
  }



  getCereriByUserId(userId: number): Observable<Cerere[]> {
    return this.http.get<Cerere[]>(`${SERVER_API_URL}/cereri/${userId}`);
  }

}

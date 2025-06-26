import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Cerere} from '../../services/cerere.model';
import {CereriService} from '../../services/cereri.service';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-cereri-locatar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cereri-locatar.component.html',
  styleUrl: './cereri-locatar.component.css'
})
export class CereriLocatarComponent {
  cereri: Cerere[] = [];

  constructor(private cereriService: CereriService, private router: Router, private authService: AuthService){

     cereriService.getCereriForCurrentUser().subscribe({
       next: res => {
         console.log("Get user cereri", res);
         // @ts-ignore
         this.cereri = res.map(x => x);
         },
          error: (err) => console.error('Eroare la get user cereri', err)
         })
  }

  addCerere() {
    this.router.navigate(['/cereri/locatar/new']);
  }

  goBack() {
    this.router.navigate(['/dashboard-locatar']);
  }
  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}

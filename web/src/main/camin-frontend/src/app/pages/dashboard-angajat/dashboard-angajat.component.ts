import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-dashboard-angajat',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-angajat.component.html',
  styleUrls: ['./dashboard-angajat.component.css']
})
export class DashboardAngajatComponent {
  cereri = [
    { id: 1, camera: 101, descriere: '...' },
    { id: 2, camera: 105, descriere: '...' },
    { id: 3, camera: 130, descriere: '...' }
  ];

  constructor(private authService: AuthService, private router: Router) {}

  preiaCerere(id: number) {
    console.log(`Cererea ${id} a fost preluată.`);
  }

  stergeCerere(id: number) {
    this.cereri = this.cereri.filter(cerere => cerere.id !== id);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}

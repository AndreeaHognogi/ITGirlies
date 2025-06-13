import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard-locatar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-locatar.component.html',
  styleUrls: ['./dashboard-locatar.component.css']
})
export class DashboardLocatarComponent {
  cereri = [
    { id: 1, specializare: 'Instalator', status: 'ÎN PROGRES' },
    { id: 2, specializare: 'Electrician', status: 'FINALIZAT' },
    { id: 3, specializare: 'Tamplar', status: 'PRELUAT' }
  ];

  constructor(private authService: AuthService, private router: Router) {
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }
}

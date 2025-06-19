import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import {CereriService} from '../../services/cereri.service';

@Component({
  selector: 'app-dashboard-admin',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-admin.component.html',
  styleUrls: ['./dashboard-admin.component.css']
})
export class DashboardAdminComponent {

  constructor(private authService: AuthService, private cereriService: CereriService, private router: Router) {
  }

  goToUsers() {
    this.router.navigate(['/users']);
  }

  goToCereri() {
    this.router.navigate(['/cereri']);
  }

  goToLocatarDashboard() {
    this.router.navigate(['/dashboard-locatar']);
  }

  goToAngajatDashboard() {
    this.router.navigate(['/dashboard-angajat']);
  }

  logout() {
    this.authService.logout();
    localStorage.removeItem('token');
    this.router.navigate(['/login'])
  }
}

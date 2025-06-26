import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import {CereriService} from '../../services/cereri.service';
import {Cerere} from '../../services/cerere.model';

@Component({
  selector: 'app-dashboard-angajat',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-angajat.component.html',
  styleUrls: ['./dashboard-angajat.component.css']
})
export class DashboardAngajatComponent implements OnInit{
  cereri: Cerere[] = [];

  constructor(private cereriService: CereriService, private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.cereriService.getCereri().subscribe(data => {
      this.cereri = data;
    });
  }

  goToCereri() {
    this.router.navigate(['/cereri-angajat']);
  }
  finalizeazaCerere(cerere: Cerere): void {
    const updated = { ...cerere, status: 'DONE' };
    this.cereriService.updateCerere(cerere.id, updated).subscribe(() => {
      cerere.status = 'DONE';
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}

import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import {CerereComponent} from '../cerere/cerere.component';
import {CereriService} from '../../services/cereri.service';

@Component({
  selector: 'app-dashboard-admin',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-admin.component.html',
  styleUrls: ['./dashboard-admin.component.css']
})
export class DashboardAdminComponent implements OnInit{
  cereri : CerereComponent[] = [];
    // { nume: 'NUME1', utilizator: 'numeutilizator1' },
    // { nume: 'NUME2', utilizator: 'numeutilizator2' },
    // { nume: 'NUME3', utilizator: 'numeutilizator3' }

  constructor(private authService: AuthService, private cereriService: CereriService, private router: Router) {
  }

  ngOnInit(): void {
        throw new Error('Method not implemented.');
    }
  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }
}

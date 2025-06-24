import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import {Cerere} from '../../services/cerere.model';
import {CereriService} from '../../services/cereri.service';

@Component({
  selector: 'app-dashboard-locatar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-locatar.component.html',
  styleUrls: ['./dashboard-locatar.component.css']
})
export class DashboardLocatarComponent implements OnInit{
  cereri: Cerere[] = [];

  constructor(private cereriService: CereriService, private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.cereriService.getCereri().subscribe(data => {
      this.cereri = data;
    });
    // if (!this.authService.isLoggedIn()) {
    //   this.router.navigate(['/login']);
    // }
  }

  goToCereri() {
    this.router.navigate(['/cereri-locatar']);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }
}

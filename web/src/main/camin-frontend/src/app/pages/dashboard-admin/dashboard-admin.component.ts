import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard-admin',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard-admin.component.html',
  styleUrls: ['./dashboard-admin.component.css']
})
export class DashboardAdminComponent {
  cereri = [
    { nume: 'NUME1', utilizator: 'numeutilizator1' },
    { nume: 'NUME2', utilizator: 'numeutilizator2' },
    { nume: 'NUME3', utilizator: 'numeutilizator3' }
  ];
}

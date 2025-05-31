import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

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
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

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


  preiaCerere(id: number) {
    console.log(`Cererea ${id} a fost preluată.`);
  }

  stergeCerere(id: number) {
    this.cereri = this.cereri.filter(cerere => cerere.id !== id);
  }
}

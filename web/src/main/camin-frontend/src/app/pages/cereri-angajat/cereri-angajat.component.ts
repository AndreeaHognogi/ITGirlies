import {Component, OnInit} from '@angular/core';
import {CereriService} from '../../services/cereri.service';
import {CommonModule} from '@angular/common';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cereri-angajat',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cereri-angajat.component.html',
  styleUrl: './cereri-angajat.component.css'
})
export class CereriAngajatComponent implements OnInit {
  cereri: {
    id: string,
    subiect: string,
    descriere: string,
    data: string,
    status: 'PENDING' | 'APPROVED' | 'REJECTED' | 'DONE'
  }[] = [];

  constructor(
    private cereriService: CereriService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadApprovedCereri();
  }

  loadApprovedCereri() {
    this.cereriService.getCereri().subscribe({
      next: res => {
        // @ts-ignore
        this.cereri = res.filter(c => c.status === 'APPROVED');
      },
      error: err => console.error('Eroare la cereri', err)
    });
  }

  finalizeazaCerere(cerere: any) {
    const updatedCerere = {
      ...cerere,
      status: 'DONE'
    };

    this.cereriService.updateCerere(cerere.id, updatedCerere).subscribe({
      next: res => {
        cerere.status = 'DONE'; // update UI
      },
      error: err => console.error('Eroare la finalizare', err)
    });
  }

  goBack() {
    this.router.navigate(['/dashboard-angajat']);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}

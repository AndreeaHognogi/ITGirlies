import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {CereriService} from '../../services/cereri.service';

@Component({
  selector: 'app-cerere',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cerere.component.html',
  styleUrls: ['./cerere.component.css']
})
export class CerereComponent {
  cereri :{
    id: string,
    subiect: string,
    descriere: string,
    data: string,
    status: 'PENDING' | 'ACCEPTED' | 'REJECTED' | 'IN_PROGRESS' | 'DONE'
  }[] = [];

  constructor(private authService: AuthService, private cereriService: CereriService, private router: Router) {
    cereriService.getCereri().subscribe({
      next: res => {
        console.log("Get all cereri", res);
        // @ts-ignore
        this.cereri = res.map(x => x);
      },
      error: (err) => console.error('Eroare la get all cereri', err)
    })
  }


  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }

  editCerere(cerereId: string) {
    this.router.navigate([`/cereri/${cerereId}`]);
  }

  deleteCerere(cerereId: string) {
    this.cereriService.deleteCerere(cerereId).subscribe({
      next: res => {
        console.log("Cerere stearsa cu success")
        this.cereri = this.cereri.filter(cerere => cerere.id != cerereId);
      },
      error: (err) => console.error('Eroare la get all cereri', err)
    });
  }

  validateCerere(cerereId: string, user: any) {
    user.validated = true;
    this.cereriService.updateCerere(cerereId, user).subscribe({
      next: res => {
        console.log("S-a validat cu success", res);
      },
      error: (err) => console.error('Eroare la get all cereri', err)
    })
  }

  addCerere() {
    this.router.navigate(['/cereri/new']);
  }

  // onSubmit() {
  //   console.log('Cerere trimisă:', {
  //     // nume: this.nume,
  //     // camera: this.camera,
  //     // specializare: this.specializare,
  //     // problema: this.problema
  //   });
  // }

}

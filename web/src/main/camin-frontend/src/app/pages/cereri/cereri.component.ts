import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {CereriService} from '../../services/cereri.service';
import {Router} from '@angular/router';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-cereri',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cereri.component.html',
  styleUrl: './cereri.component.css'
})
export class CereriComponent implements OnInit{
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

  ngOnInit() {
    const role = this.authService.getDecodedToken()?.role;
    if (role === 'Locatar') {
      this.loadCereriUser(); // doar cererile propriului utilizator
    } else {
      this.loadAllCereri(); // toate cererile
    }
  }
  loadCereriUser(): void {
    this.cereriService.getCereriByUser().subscribe({
      next: (cereri) => {
        this.cereri = cereri;
      },
      error: (err) => {
        console.error('Eroare la încărcarea cererilor userului:', err);
      }
    });
  }

  loadAllCereri(): void {
    this.cereriService.getCereri().subscribe({
      next: (cereri) => {
        this.cereri = cereri;
      },
      error: (err) => {
        console.error('Eroare la încărcarea tuturor cererilor:', err);
      }
    });
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

  validateCerere(cerereId: string, cerere: any, newStatus:String) {
    const updatedCerere = {
      ...cerere,
      status: newStatus
    };

    this.cereriService.updateCerere(cerereId, updatedCerere).subscribe({
      next: res => {
        console.log("Status actualizat cu succes:", res);
        cerere.status = newStatus; // optional, pentru update imediat în UI
      },
      error: (err) => console.error('Eroare la actualizarea statusului cererii', err)
    });
  }

  addCerere() {
    this.router.navigate(['/cereri/new']);
  }

  goToUser(userId: number) {
    this.router.navigate(['/users', userId]);
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


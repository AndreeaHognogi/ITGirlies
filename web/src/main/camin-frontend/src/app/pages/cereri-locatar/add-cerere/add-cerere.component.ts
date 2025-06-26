import { Component } from '@angular/core';
import {FormBuilder, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {CereriService} from '../../../services/cereri.service';
import {Router} from '@angular/router';
import {AuthService} from '../../../services/auth.service';

@Component({
  selector: 'app-add-cerere',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './add-cerere.component.html',
  styleUrl: './add-cerere.component.css'
})
export class AddCerereComponent {
  cerere = {
    subiect: '',
    descriere: '',
    data: ''
  };

  constructor(
    private authService: AuthService,
    private cerereService: CereriService,
    private router: Router
  ) {}

  onSubmit() {
    this.cerereService.addCereriLocatar(this.cerere).subscribe(() => {
      console.log('Cerere adăugată cu succes');
      this.router.navigate(['/cereri-locatar']);
    });
  }
  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
  goBack() {
    this.router.navigate(['/cereri-locatar']);
  }
}

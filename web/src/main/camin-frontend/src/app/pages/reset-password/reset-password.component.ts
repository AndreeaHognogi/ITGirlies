import { Component } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-reset-password',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reset-password.component.html',
  styleUrl: './reset-password.component.css'
})
export class ResetPasswordComponent {
  email: string = '';
  newPassword: string = '';
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private authService: AuthService, private router: Router) {
  }

  resetPassword() {
    if (!this.email || !this.newPassword) {
      this.errorMessage = 'Te rugăm să completezi toate câmpurile.';
      return;
    }

    this.authService.resetPassword(this.email, this.newPassword).subscribe({
      next: () => {
        this.successMessage = 'Parola a fost resetată cu succes!';
        this.errorMessage = null;
        setTimeout(() => this.router.navigate(['/login']), 2000);
      },
      error: err => {
        this.errorMessage = err.error?.message || 'Eroare la resetarea parolei.';
        this.successMessage = null;
      }
    });
  }
  goBack(): void {
    this.router.navigate(['/login']);
  }
}


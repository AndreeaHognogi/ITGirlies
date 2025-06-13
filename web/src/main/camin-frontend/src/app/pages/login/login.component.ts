import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  email: string = '';
  parola: string = '';
  errorMessage: string | null = null;

  constructor(private authService: AuthService, private router: Router){

  }

  navigateBasedOnRole(role: String) {
    switch(role.toLowerCase()) {
      case 'admin':
        this.router.navigate(['dashboard-admin']);
        break;
      case 'angajat':
        this.router.navigate(['dashboard-angajat']);
        break;
      case 'locatar':
        this.router.navigate(['dashboard-locatar']);
        break;
      default:
        this.router.navigate(['unauthorized']);
        break;
    }
  }

  onSubmit() {
    this.authService.login(this.email, this.parola).subscribe({
      next: res => {
        this.errorMessage = null;
        console.log("Login reusit, redirect la homepage");
        console.log("Decoded token info: ", this.authService.getDecodedToken());
        const role: String = this.authService.getRoleFromToken();
        this.navigateBasedOnRole(role);
      },
      error: (err) => {
        this.errorMessage = err.error || 'Authentificare nereusita';
        console.error('Eroare la login', err);
      }
    });
  }
}

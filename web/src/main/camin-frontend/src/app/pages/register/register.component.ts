import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  firstname: string = '';
  lastname: string = '';
  username: string = '';
  email: string = '';
  phone: string = '';
  role: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {
  }

  onSubmit() {
    const user = {
      firstname: this.firstname,
      lastname: this.lastname,
      username: this.username,
      email: this.email,
      phone: this.phone,
      role: this.role,
      password: this.password,

    }
    this.authService.register(user).subscribe({
      next: res => {
        console.log("Register reusit, redirect la login");
        this.router.navigate(['login']);
      },
      error: (err) => console.error('Eroare la login', err)
    });
  }
}

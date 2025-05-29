import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-autentificare',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './autentificare.component.html',
  styleUrls: ['./autentificare.component.css']
})
export class AutentificareComponent {
  nume = '';
  email = '';
  parola = '';

  onSubmit() {
    console.log('Formular trimis:', this.nume, this.email, this.parola);
  }
}

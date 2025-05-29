import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cerere',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cerere.component.html',
  styleUrls: ['./cerere.component.css']
})
export class CerereComponent {
  nume = '';
  camera = '';
  specializare = '';
  problema = '';

  onSubmit() {
    console.log('Cerere trimisă:', {
      nume: this.nume,
      camera: this.camera,
      specializare: this.specializare,
      problema: this.problema
    });
  }
}

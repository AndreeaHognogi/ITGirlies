import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {CommonModule} from '@angular/common';
import {UsersService} from '../../../services/users.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CereriService} from '../../../services/cereri.service';
import {AuthService} from '../../../services/auth.service';

@Component({
  selector: 'app-new-cerere',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './new-cerere.component.html',
  styleUrl: './new-cerere.component.css'
})
export class NewCerereComponent {
  cerere = {
    subiect: '',
    descriere: '',
    data: '',
    status: '',
    // user: '',
  };

  constructor(
    private authService: AuthService,
    private cerereService: CereriService,
    private router: Router
  ) {}

  onSubmit() {
    this.cerereService.addCereri(this.cerere).subscribe(() => {
      this.router.navigate(['/dashboard-admin']);
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }
}

import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../../../services/auth.service';
import {UsersService} from '../../../services/users.service';
import {CerereComponent} from '../cerere.component';
import {CereriService} from '../../../services/cereri.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-edit-cerere',
  imports: [
    FormsModule
  ],
  templateUrl: './edit-cerere.component.html',
  styleUrl: './edit-cerere.component.css'
})
export class EditCerereComponent implements OnInit{
  cerere = {
    id: '',
    subiect: '',
    descriere: '',
    data: '',
    status: ''
  };

  constructor(
    private route: ActivatedRoute,
    private authService: AuthService,
    private cerereService: CereriService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const cerereId = this.route.snapshot.paramMap.get('id');
    if (cerereId) {
      this.cerereService.getCerereById(cerereId).subscribe((data) => {
        // @ts-ignore
        this.user = data;
      });
    }
  }

  onSubmit(): void {
    this.cerereService.updateCerere(this.cerere.id, this.cerere).subscribe(() => {
      this.router.navigate(['/cereri']);
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }
}


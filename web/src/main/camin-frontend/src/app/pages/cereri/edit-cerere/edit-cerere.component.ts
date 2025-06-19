import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../../../services/auth.service';
import {CereriService} from '../../../services/cereri.service';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-edit-cerere',
  standalone: true,
  imports: [CommonModule, FormsModule],
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
        this.cerere = data;
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


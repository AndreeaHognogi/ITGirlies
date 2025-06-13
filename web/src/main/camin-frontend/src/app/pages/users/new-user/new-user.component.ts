import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../../../services/users.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-user',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './new-user.component.html',
  styleUrl: './new-user.component.css'
})
export class NewUserComponent {
  user = {
    username: '',
    firstname: '',
    lastname: '',
    email: '',
    phone: '',
    role: '',
    password: ''
  };


  constructor(private userService: UsersService, private router: Router) {}

  logout() {
    // implementarea logout-ului
  }

  onSubmit() {
    this.userService.addUser(this.user).subscribe(() => {
      this.router.navigate(['/dashboard-admin']);
    });
  }
}

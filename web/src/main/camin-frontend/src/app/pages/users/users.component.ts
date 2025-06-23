import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { UsersService } from '../../services/users.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {
  users:{
    id: string,
    username: string,
    firstname: string,
    lastname: string,
    email: string,
    role: string,
    phone: string,
    validated: boolean
  }[] = [];

  constructor(private authService: AuthService, private userService: UsersService, private router: Router) {
    userService.getUsers().subscribe({
      next: res => {
        console.log("Get all users", res);
        // @ts-ignore
        this.users = res.map(x => x);
      },
      error: (err) => console.error('Eroare la get all users', err)
    })
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }

  goBack(): void {
    this.router.navigate(['/dashboard-admin']);
  }

  editUser(userId: string) {
    this.router.navigate([`/users/${userId}`]);
  }

  deleteUser(userId: string) {
    this.userService.deleteUser(userId).subscribe({
      next: res => {
        console.log("User sters cu success")
        this.users = this.users.filter(user => user.id != userId);
      },
      error: (err) => console.error('Eroare la get all users', err)
    });
  }

  validateUser(userId: string, user: any) {
    user.validated = true;
    this.userService.updateUser(userId, user).subscribe({
      next: res => {
        console.log("S-a validat cu success", res);
      },
      error: (err) => console.error('Eroare la get all users', err)
    })
  }

  addUser() {
    this.router.navigate(['/users/new']);
  }
}

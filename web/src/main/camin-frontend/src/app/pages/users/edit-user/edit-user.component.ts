import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersService } from '../../../services/users.service';
import { AuthService } from '../../../services/auth.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-user',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  user = {
    id: '',
    firstname: '',
    lastname: '',
    email: '',
    phone: '',
    password: '',
    validated: '',
    role: '',
    username: ''
  };

  constructor(
    private route: ActivatedRoute,
    private authService: AuthService,
    private userService: UsersService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userId = this.route.snapshot.paramMap.get('id');
    if (userId) {
      this.userService.getUserById(userId).subscribe((data) => {
        // @ts-ignore
        this.user = data;
      });
    }
  }

  onSubmit(): void {
    this.userService.updateUser(this.user.id, this.user).subscribe(() => {
      this.router.navigate(['/users']);
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login'])
  }
}

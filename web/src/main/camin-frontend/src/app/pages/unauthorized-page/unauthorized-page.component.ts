import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-unauthorized-page',
  imports: [],
  templateUrl: './unauthorized-page.component.html',
  styleUrl: './unauthorized-page.component.css'
})
export class UnauthorizedPageComponent {
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

  redirectToDashboard() {
    const tokenInfo = this.authService.getDecodedToken();

    console.log("ce e eaici", tokenInfo)
    // @ts-ignore
    this.navigateBasedOnRole(tokenInfo?.role || "");
  }
}

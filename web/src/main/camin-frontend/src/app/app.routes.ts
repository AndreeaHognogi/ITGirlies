import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'login',
    loadComponent: () =>
      import('./pages/login/login.component').then((c) => c.LoginComponent),
  },
  {
    path: 'autentificare',
    loadComponent: () =>
      import('./pages/autentificare/autentificare.component').then((c) => c.AutentificareComponent),
  },
  {
    path: 'cerere',
    loadComponent: () =>
      import('./pages/cerere/cerere.component').then(m => m.CerereComponent)
  },
  {
    path: 'dashboard-admin',
    loadComponent: () =>
      import('./pages/dashboard-admin/dashboard-admin.component').then(m => m.DashboardAdminComponent)
  },
  {
    path: 'dashboard-angajat',
    loadComponent: () =>
      import('./pages/dashboard-angajat/dashboard-angajat.component').then(m => m.DashboardAngajatComponent)
  },
  {
    path: 'dashboard-locatar',
    loadComponent: () =>
      import('./pages/dashboard-locatar/dashboard-locatar.component').then(m => m.DashboardLocatarComponent)
  }
];

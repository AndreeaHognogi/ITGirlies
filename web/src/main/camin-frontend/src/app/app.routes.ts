import { Routes } from '@angular/router';
import { roleGuard } from './auth/role.guard';
import { UnauthorizedPageComponent } from './pages/unauthorized-page/unauthorized-page.component';

export const routes: Routes = [
  {
    path: 'login',
    loadComponent: () =>
      import('./pages/login/login.component').then((c) => c.LoginComponent),
  },
  {
    path: 'register',
    loadComponent: () =>
      import('./pages/register/register.component').then((c) => c.RegisterComponent),
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Locatar' },
    path: 'cerere',
    loadComponent: () =>
      import('./pages/cerere/cerere.component').then(m => m.CerereComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Admin' },
    path: 'dashboard-admin',
    loadComponent: () =>
      import('./pages/dashboard-admin/dashboard-admin.component').then(m => m.DashboardAdminComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Admin' },
    path: 'users',
    loadComponent: () =>
      import('./pages/users/users.component').then(m => m.UsersComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Admin' },
    path: 'users/new',
    loadComponent: () =>
      import('./pages/users/new-user/new-user.component').then(m => m.NewUserComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Admin' },
    path: 'users/:id',
    loadComponent: () =>
      import('./pages/users/edit-user/edit-user.component').then(m => m.EditUserComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Angajat' },
    path: 'dashboard-angajat',
    loadComponent: () =>
      import('./pages/dashboard-angajat/dashboard-angajat.component').then(m => m.DashboardAngajatComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Locatar' },
    path: 'dashboard-locatar',
    loadComponent: () =>
      import('./pages/dashboard-locatar/dashboard-locatar.component').then(m => m.DashboardLocatarComponent)
  },
  { path: 'unauthorized', component: UnauthorizedPageComponent },
  {
    path: '**',
    loadComponent: () =>
      import('./pages/login/login.component').then((c) => c.LoginComponent),
  }
];

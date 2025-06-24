import { Routes } from '@angular/router';
import { roleGuard } from './auth/role.guard';
import { UnauthorizedPageComponent } from './pages/unauthorized-page/unauthorized-page.component';
import {LoginComponent} from './pages/login/login.component';
import {RegisterComponent} from './pages/register/register.component';
import {CereriComponent} from './pages/cereri/cereri.component';
import {DashboardLocatarComponent} from './pages/dashboard-locatar/dashboard-locatar.component';
import {DashboardAngajatComponent} from './pages/dashboard-angajat/dashboard-angajat.component';

export const routes: Routes = [

  // { path: 'login', component: LoginComponent },
  // { path: 'register', component: RegisterComponent },
  // { path: 'cereri', component: CereriComponent },
  // { path: 'locatar', component: DashboardLocatarComponent},
  // { path: 'angajat', component: DashboardAngajatComponent},
  // // fallback
  // { path: '**', redirectTo: 'login' },
  {
    path: 'login',
    loadComponent: () =>
      import('./pages/login/login.component').then((c) => c.LoginComponent),
  },
  {
    path: 'reset-password',
    loadComponent: () => import('./pages/reset-password/reset-password.component').then(m => m.ResetPasswordComponent)
  },
  {
    path: 'register',
    loadComponent: () =>
      import('./pages/register/register.component').then((c) => c.RegisterComponent),
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Admin' },
    path: 'cereri',
    loadComponent: () =>
      import('./pages/cereri/cereri.component').then(m => m.CereriComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Admin' },
    path: 'cereri/new',
    loadComponent: () =>
      import('./pages/cereri/new-cerere/new-cerere.component').then(m => m.NewCerereComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Admin' },
    path: 'cereri/:id',
    loadComponent: () =>
      import('./pages/cereri/edit-cerere/edit-cerere.component').then(m => m.EditCerereComponent)
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

  // {
  //   canActivate: [roleGuard],
  //   data: { expectedRole: ['Admin', 'Locatar', 'Angajat'] },  // presupunem că roleGuard știe să gestioneze asta
  //   path: 'cereri',
  //   loadComponent: () =>
  //     import('./pages/cereri/cereri.component').then(m => m.CereriComponent)
  // },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Locatar' },
    path: 'cereri-locatar',
    loadComponent: () =>
      import('./pages/cereri/cereri.component').then(m => m.CereriComponent)
  },
  {
    canActivate: [roleGuard],
    data: { expectedRole: 'Angajat' },
    path: 'cereri-angajat',
    loadComponent: () =>
      import('./pages/cereri/cereri.component').then(m => m.CereriComponent)
  },


  { path: 'unauthorized', component: UnauthorizedPageComponent },
  {
    path: '**',
    loadComponent: () =>
      import('./pages/login/login.component').then((c) => c.LoginComponent),
  }
];

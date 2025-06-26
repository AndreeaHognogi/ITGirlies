import { inject } from '@angular/core';
import {CanActivateFn, Router} from '@angular/router';
import { AuthService } from '../services/auth.service';

export const roleGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const authService = inject(AuthService);

  if (authService.isTokenExpired()) {
    router.navigate(['/login']);
    return false;
  }

  const decodedToken = authService.getDecodedToken() as any;
  // @ts-ignore
  const userRole = decodedToken?.role?.toLowerCase();
  const expectedRole = route.data?.['expectedRole'];

  // if (userRole.toLowerCase() === expectedRole.toLowerCase()) {
  //   return true;
  // }

  // Extrage roluri din token (role sau roles)
  let userRoles: string[] = [];

  // Normalizează ambele variante: `role` și `roles`
  if (decodedToken?.role) {
    userRoles.push(decodedToken.role.toLowerCase());
  }

  if (Array.isArray(decodedToken?.roles)) {
    userRoles.push(...decodedToken.roles.map((r: string) => r.toLowerCase()));
  }

  if (Array.isArray(expectedRole)) {
    const allowed = expectedRole.some((role: string) =>
      userRoles.includes(role.toLowerCase())
    );
    if (allowed) return true;
  } else if (typeof expectedRole === 'string') {
    if (userRoles.includes(expectedRole.toLowerCase())) return true;
  }

  router.navigate(['/unauthorized']);
  return false;

};

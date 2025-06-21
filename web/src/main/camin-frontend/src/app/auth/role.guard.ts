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

  const decodedToken = authService.getDecodedToken();
  // @ts-ignore
  const userRole = decodedToken?.role?.toLowerCase();
  const expectedRole = route.data?.['expectedRole'];

  // if (userRole.toLowerCase() === expectedRole.toLowerCase()) {
  //   return true;
  // }
  if (Array.isArray(expectedRole)) {
    const allowed = expectedRole.some((role: string) => role.toLowerCase() === userRole);
    if (allowed) {
      return true;
    }
  } else if (typeof expectedRole === 'string') {
    if (userRole === expectedRole.toLowerCase()) {
      return true;
    }
  }

  router.navigate(['/unauthorized']);
  return false;

};

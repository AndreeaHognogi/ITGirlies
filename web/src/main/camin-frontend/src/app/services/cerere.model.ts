export interface Cerere {
  id: string;
  subiect: string,
  descriere: string;
  data: string;
  status: 'PENDING' | 'APPROVED' | 'REJECTED' | 'DONE';

  // angajatId?: number; // opțional, dacă vrei să salvezi angajatul care a preluat cererea
}


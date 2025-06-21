export interface Cerere {
  id: string;
  subiect: string,
  descriere: string;
  data: string;
  status: 'PENDING' | 'ACCEPTED' | 'REJECTED' | 'IN_PROGRESS' | 'DONE';

  // angajatId?: number; // opțional, dacă vrei să salvezi angajatul care a preluat cererea
}


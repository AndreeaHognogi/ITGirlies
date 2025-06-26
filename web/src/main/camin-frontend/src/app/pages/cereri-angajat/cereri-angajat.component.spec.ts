import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CereriAngajatComponent } from './cereri-angajat.component';

describe('CereriAngajatComponent', () => {
  let component: CereriAngajatComponent;
  let fixture: ComponentFixture<CereriAngajatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CereriAngajatComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CereriAngajatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

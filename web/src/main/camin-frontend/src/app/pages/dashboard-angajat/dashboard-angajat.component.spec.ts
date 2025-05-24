import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardAngajatComponent } from './dashboard-angajat.component';

describe('DashboardAngajatComponent', () => {
  let component: DashboardAngajatComponent;
  let fixture: ComponentFixture<DashboardAngajatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardAngajatComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardAngajatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

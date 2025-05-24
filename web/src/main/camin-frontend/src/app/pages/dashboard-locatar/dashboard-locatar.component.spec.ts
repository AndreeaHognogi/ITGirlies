import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardLocatarComponent } from './dashboard-locatar.component';

describe('DashboardLocatarComponent', () => {
  let component: DashboardLocatarComponent;
  let fixture: ComponentFixture<DashboardLocatarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardLocatarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardLocatarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

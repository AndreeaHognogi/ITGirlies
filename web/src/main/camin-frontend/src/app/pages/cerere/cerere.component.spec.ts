import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CerereComponent } from './cerere.component';

describe('CerereComponent', () => {
  let component: CerereComponent;
  let fixture: ComponentFixture<CerereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CerereComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CerereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCerereComponent } from './new-cerere.component';

describe('NewCerereComponent', () => {
  let component: NewCerereComponent;
  let fixture: ComponentFixture<NewCerereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewCerereComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewCerereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCerereComponent } from './edit-cerere.component';

describe('EditCerereComponent', () => {
  let component: EditCerereComponent;
  let fixture: ComponentFixture<EditCerereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditCerereComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditCerereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

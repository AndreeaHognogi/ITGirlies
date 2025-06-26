import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CereriLocatarComponent } from './cereri-locatar.component';

describe('CereriLocatarComponent', () => {
  let component: CereriLocatarComponent;
  let fixture: ComponentFixture<CereriLocatarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CereriLocatarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CereriLocatarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

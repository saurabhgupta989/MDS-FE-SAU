import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityTab1Component } from './facility-tab1.component';

describe('FacilityTab1Component', () => {
  let component: FacilityTab1Component;
  let fixture: ComponentFixture<FacilityTab1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityTab1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityTab1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

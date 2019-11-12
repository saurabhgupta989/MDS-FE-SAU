import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityTab4Component } from './facility-tab4.component';

describe('FacilityTab4Component', () => {
  let component: FacilityTab4Component;
  let fixture: ComponentFixture<FacilityTab4Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityTab4Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityTab4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

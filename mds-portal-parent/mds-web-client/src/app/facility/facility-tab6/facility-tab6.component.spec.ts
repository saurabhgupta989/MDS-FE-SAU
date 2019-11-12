import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityTab6Component } from './facility-tab6.component';

describe('FacilityTab6Component', () => {
  let component: FacilityTab6Component;
  let fixture: ComponentFixture<FacilityTab6Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityTab6Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityTab6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

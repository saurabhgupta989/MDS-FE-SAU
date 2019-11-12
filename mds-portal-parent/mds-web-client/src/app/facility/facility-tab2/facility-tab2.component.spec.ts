import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityTab2Component } from './facility-tab2.component';

describe('FacilityTab2Component', () => {
  let component: FacilityTab2Component;
  let fixture: ComponentFixture<FacilityTab2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityTab2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityTab2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

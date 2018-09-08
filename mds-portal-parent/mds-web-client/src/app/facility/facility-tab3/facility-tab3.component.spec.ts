import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityTab3Component } from './facility-tab3.component';

describe('FacilityTab3Component', () => {
  let component: FacilityTab3Component;
  let fixture: ComponentFixture<FacilityTab3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityTab3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityTab3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

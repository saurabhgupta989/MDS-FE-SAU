import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityTab5Component } from './facility-tab5.component';

describe('FacilityTab5Component', () => {
  let component: FacilityTab5Component;
  let fixture: ComponentFixture<FacilityTab5Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityTab5Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityTab5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

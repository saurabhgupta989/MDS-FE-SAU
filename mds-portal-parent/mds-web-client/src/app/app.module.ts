import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { StepsModule } from '../../node_modules/primeng/steps';
import { StepscustomModule } from '../../node_modules/primeng/stepscustom';
import { FacilityComponent } from './facility/facility.component';
import { FacilityTab1Component } from './facility/facility-tab1/facility-tab1.component';
import { FacilityTab2Component } from './facility/facility-tab2/facility-tab2.component';
import { FacilityTab3Component } from './facility/facility-tab3/facility-tab3.component';
import { FacilityTab4Component } from './facility/facility-tab4/facility-tab4.component';
import { FacilityTab5Component } from './facility/facility-tab5/facility-tab5.component';
import { FacilityTab6Component } from './facility/facility-tab6/facility-tab6.component';
import { MyService } from './service/my-service';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FacilityComponent,
    FacilityTab1Component,
    FacilityTab2Component,
    FacilityTab3Component,
    FacilityTab4Component,
    FacilityTab5Component,
    FacilityTab6Component
  ],
  imports: [
    BrowserModule, StepsModule, StepscustomModule, HttpModule
  ],
  providers: [MyService],
  bootstrap: [AppComponent]
})
export class AppModule { }

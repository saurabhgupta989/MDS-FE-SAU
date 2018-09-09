import { Component, OnInit, ViewEncapsulation, Renderer2, ElementRef, ViewChild } from '@angular/core';
import { Steps,StepsModule } from 'primeng/steps';
import { MenuItem } from 'primeng/api';
import { MyService } from '../service/my-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

  items: MenuItem[];

  activeIndex: number = 0;
  @ViewChild('stepsDiv') elRef2: ElementRef;
  constructor(private renderer: Renderer2, public _myService: MyService) { }

  ngOnInit() {
    this.items = [{ label: 'step1' }, { label: 'step2' }, { label: 'step3' }, { label: 'step4' }];
  }


  nextStepPlease() {
    this.activeIndex++;
    Steps.prototype.itemClick(event, Steps.prototype, this.activeIndex, true, true);

    let lists = this.elRef2.nativeElement.querySelectorAll('li');
    for (let i = 0; i <= this.activeIndex - 1; i++) {
      this.renderer.setStyle(lists[i], 'background', 'green');
      this.renderer.setStyle(lists[i], 'opacity', '1');
      this.renderer.addClass(lists[i], 'anyClassIfWantToAdd');
    }
    this.renderer.setStyle(lists[this.activeIndex], 'background', '#186ba0');
    this.renderer.setStyle(lists[this.activeIndex], 'opacity', '1');

  }

  clickMe() {

    this._myService.loaddata();

  }

}

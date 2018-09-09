import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  loginForm: FormGroup;
  uname='';
  ngOnInit() {
    this.loginForm = this.fb.group({
      uname: new FormControl(''),
      psw: new FormControl('')
    });
  }

  login() {
    console.log("Hi", this.uname);
  }
}

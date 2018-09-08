import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
// import 'rxjs/Rx';
// import { Observable } from 'rxjs/Rx'
// import { Observable } from '../../../node_modules/rxjs';

@Injectable()
export class MyService {
    constructor(public http: Http) { }

    serviceData: any;
    private extractData(res) {

        if (res.status < 200 || res.status >= 300) {
            throw new Error('Bad response status: ' + res.status);
        }



        console.log(res.json());
        this.serviceData = (res.json());
        return this.serviceData || {};
    }

    server_url = "http://localhost:8080/fe/test";

    loaddata(): any {

        return this.http.get(this.server_url) // define a variable server_url to assign the requested url
            .subscribe(this.extractData);
    }
}
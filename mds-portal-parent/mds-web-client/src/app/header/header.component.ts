import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { MenuItem } from '../../../node_modules/primeng/api';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css'],
    encapsulation: ViewEncapsulation.None
})
export class HeaderComponent implements OnInit {

    constructor() { }

    items: MenuItem[];
    isVisible = false;
    ngOnInit() {
        this.items = [
            {
                label: 'Home',
                icon: 'pi pi-fw pi-home'
            },
            {
                label: 'Project',
                icon: 'pi pi-fw pi-file',
                items: [{
                    label: 'New',
                    icon: 'pi pi-fw pi-plus',
                    items: [
                        { label: 'Facility' },
                        { label: 'Product Profile' },
                    ]
                },
                { label: 'Open' },
                { separator: true },
                { label: 'Quit' }
                ]
            },
            {
                label: 'Edit',
                icon: 'pi pi-fw pi-pencil',
                items: [
                    { label: 'Delete', icon: 'pi pi-fw pi-trash' },
                    { label: 'Refresh', icon: 'pi pi-fw pi-refresh' }
                ]
            },
            {
                label: 'Help',
                icon: 'pi pi-fw pi-question',
                items: [
                    {
                        label: 'Contact Us',
                        icon: 'pi pi-fw pi-tags'
                    },
                    {
                        label: 'FAQ',
                        icon: 'pi pi-fw pi-tags',
                    },
                    {
                        label: 'Terms & Conditions',
                        icon: 'pi pi-fw pi-tags',
                    }
                ]
            },
            {
                label: 'Actions',
                icon: 'pi pi-fw pi-cog',
                items: [
                    {
                        label: 'Edit',
                        icon: 'pi pi-fw pi-pencil',
                        items: [
                            { label: 'Save', icon: 'pi pi-fw pi-save' },
                            { label: 'Update', icon: 'pi pi-fw pi-save' },
                        ]
                    },
                    {
                        label: 'Other',
                        icon: 'pi pi-fw pi-tags',
                        items: [
                            { label: 'Delete', icon: 'pi pi-fw pi-minus' }
                        ]
                    }
                ]
            }
        ];
    }

}

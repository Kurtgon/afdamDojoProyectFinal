import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router'


@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.scss']
})
export class TopNavComponent implements OnInit {

  @Output() sideNavToggled = new EventEmitter<void>();
  
  constructor(private readonly router: Router) { }

  ngOnInit(): void {
  }

  toggleSidebar(): void {
    this.sideNavToggled.emit();
  }

  //Cerrar sesión 
  onLoggedout():void {
    //'liloggedin'
    localStorage.removeItem('');
    this.router.navigate(['/']);
  }

}

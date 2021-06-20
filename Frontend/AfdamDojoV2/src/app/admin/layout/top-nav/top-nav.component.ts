import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../../services/login.service';


@Component({
  selector: 'app-top-nav',
  templateUrl: './top-nav.component.html',
  styleUrls: ['./top-nav.component.scss']
})
export class TopNavComponent implements OnInit {

  @Output() sideNavToggled = new EventEmitter<void>();
  
  constructor(private readonly router: Router, private login:LoginService) { }

  ngOnInit(): void {
  }

  toggleSidebar(): void {
    this.sideNavToggled.emit();
  }

  //Cerrar sesión 
  logout(){
    localStorage.clear();
    this.login.logout();
    this.router.navigate(['/login']);
  }


}

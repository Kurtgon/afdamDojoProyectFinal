import { Injectable, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { JwtAuthService } from './jwt-auth.service';
import { environment } from '../../environments/environment';
import { User } from '../interfaces/userInterface';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import jwt_decode from 'jwt-decode';



@Injectable({
  providedIn: 'root'
})
export class LoginService {

  @Output() modificacionesUsuario = new EventEmitter<User>();

  readonly ISLOGUEADO = 'islogueado';
  public loginUrl = '';
  public LoginStatus = new Subject<boolean>();
  public changeLoginStatus$ = this.LoginStatus.asObservable();


  constructor(private http: HttpClient, private jwt: JwtAuthService, private router: Router) { }

  autenticarUsuario(username: string, password: string) {
    let userLoguer = {
      username: username,
      password: password
    }

    this.http.post(environment.loginUrl, userLoguer, { responseType: 'text' }).subscribe(
      (response) => {
        if (response != null && response != undefined) {

          //let jwtDecode: any = jwt_decode(response);

          localStorage.setItem(this.ISLOGUEADO, 'true');
          this.LoginStatus.next(true);

          this.jwt.guardarJwt(response);

          Swal.fire({
            title: `Bienvenido ${username}`,
            text: 'Acabas de loguearte',
            icon: 'success',
          });

          this.router.navigate(['/dashboard']);
        }
      },
      (error) => {
        Swal.fire({
          title: `${error.error.message}`,
          text: 'Exception',
          icon: 'error',
        });
      }
    );
  }

  logout() {
    // borra el localStorage 
    localStorage.clear();
    this.LoginStatus.next(false);
    Swal.fire({
      title: 'Hasta la próxima',
      text: 'Saliendo de la sesión',
      icon: 'success',
    });

    this.router.navigate(['/login']);
  }

  isLogged(url: string) {
    const isLogueado = localStorage.getItem(this.ISLOGUEADO);

    if (!isLogueado) {
      this.loginUrl = url;

      return false;
    }

    return true;
  }

}

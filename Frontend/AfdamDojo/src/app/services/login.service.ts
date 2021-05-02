import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

import { User } from '../interfaces/user';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  user: User = {
    username:"",
    password:""
  }

 

  constructor(private http: HttpClient) {
   }

   loginUsuario(username: string, password: string) : Observable <string>{
     this.user = {
       username: username,
       password: password
     }
     // Hace una petición y devuelve un observable que podemos suscribirnos
      return this.http.post('http://localhost:8080/user/login', this.user, { responseType:'text' } ).pipe(

        tap(res => {
          console.log('Datos recibidos de ' + res)
        })

      );
      
   }
}

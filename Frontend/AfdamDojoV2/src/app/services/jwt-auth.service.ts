import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtAuthService {

  constructor() { }
  
  //Guardo el JWT recibido del servidor en el almacenamiento local
  guardarJwt(token:string) {
    localStorage.setItem("jwt",token);
  }

  //Recuperar el token jwt
  obtenerJwt(): string {
    return localStorage.getItem("jwt");
  }

  // Elimino el token jwt almacenado
  eliminarJwt() {
    localStorage.removeItem("jwt");
  }
}

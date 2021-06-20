import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { JwtAuthService } from '../services/jwt-auth.service';
import { AlertasService } from '../services/alertas.service';
import { LoginService } from '../services/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  ocultarPassword: boolean = true;

  constructor(private router: Router, private jwtAtuh: JwtAuthService, private loginService: LoginService, private alertas: AlertasService) { }

  ngOnInit(): void {

    //Iniciamos el Formgroup para el formulario reactivo
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.minLength(4)]),
      password: new FormControl('',[Validators.required, Validators.minLength(4)])
    });
  }

  autenticarUsuario(){
    //Usamos el loginService para enviar los datos del usuario logueado y suscribirme a la respuesta del servidor
    this.loginService.autenticarUsuario(this.loginForm.controls.username.value, this.loginForm.controls.password.value)
  };

}

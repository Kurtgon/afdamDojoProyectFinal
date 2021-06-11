import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  ocultarPassword: boolean = true;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      usuario: new FormControl('', [Validators.required, Validators.minLength(4)]),
      password: new FormControl('', [Validators.required, Validators.minLength(4)])
    });
  }

  autenticaUsuario() {

    this.loginService.loginUsuario(this.loginForm.controls.usuario.value,
      this.loginForm.controls.password.value).subscribe(res => {
        console.log(res);
        if (res != undefined) {
          this.router.navigate(['/panelAdmin']);
        } else {
          console.log('Datos incorrectos');
        }

      });

  };



}



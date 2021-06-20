import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import Swal from 'sweetalert2';

import { Profesor } from '../../interfaces/Profesor';

import { GestionUsuarioService } from '../../services/gestion-usuario.service';

@Component({
  selector: 'app-nuevo-profesor',
  templateUrl: './nuevo-profesor.component.html',
  styleUrls: ['./nuevo-profesor.component.scss']
})
export class NuevoProfesorComponent implements OnInit {

  profesor = new Profesor;

  profesorForm: FormGroup;

  constructor(private router: Router,private gestionUsuarioService : GestionUsuarioService, private formGroup: FormBuilder) { }

  ngOnInit(): void {

    this.profesorForm = this.formGroup.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      name: ['', Validators.required],
      surnames: ['', Validators.required],
      birthdate: ['', Validators.required],
      curp: ['', Validators.required],
      tlf: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', Validators.required]
    });
  }

  // Nos suscribimos al servicio de gestión de usuarios para crear al profesor
  crearProfesor(){

    this.profesor.username = this.profesorForm.controls.username.value;
    this.profesor.password = this.profesorForm.controls.password.value;
    this.profesor.name = this.profesorForm.controls.name.value;
    this.profesor.surnames = this.profesorForm.controls.surnames.value;
    this.profesor.birthdate = this.profesorForm.controls.birthdate.value;
    this.profesor.curp = this.profesorForm.controls.curp.value;
    this.profesor.tlf = this.profesorForm.controls.tlf.value;
    this.profesor.address = this.profesorForm.controls.address.value;
    this.profesor.email = this.profesorForm.controls.email.value;

    console.log(this.profesor);

    this.gestionUsuarioService.crearProfesor(this.profesor).subscribe((profesor: any) => {
     Swal.fire(`El profesor ${this.profesor.name} ha sido creado correctamente`)
      this.router.navigate(['/gestionUsuarios']);
    })
  };
}

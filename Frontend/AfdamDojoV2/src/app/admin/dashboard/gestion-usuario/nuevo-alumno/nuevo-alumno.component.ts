import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Router } from '@angular/router';

import { Alumno } from '../../interfaces/Alumno';
import { Disciplina } from '../../interfaces/Disciplina';
import { AlergiaGravedad } from '../../interfaces/AlergiaGravedad';

import { GestionUsuarioService } from '../../services/gestion-usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nuevo-alumno',
  templateUrl: './nuevo-alumno.component.html',
  styleUrls: ['./nuevo-alumno.component.scss']
})
export class NuevoAlumnoComponent implements OnInit {

  alumno = new Alumno;
  //alumno: Alumno;

  alumnoForm: FormGroup;
  disciplinas: Disciplina[] = [];
  alergiaGravedad: AlergiaGravedad [] = [];

  constructor(private router: Router,private gestionUsuarioService : GestionUsuarioService, private formGroup: FormBuilder) { }

  ngOnInit(): void {
    
    this.alumnoForm = this.formGroup.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      name: ['', Validators.required],
      surnames: ['', Validators.required],
      birthdate: ['', Validators.required],
      curp: ['', Validators.required],
      tlf: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', Validators.required],
      contact: ['', Validators.required],
      discipline: ['', Validators.required],
      allergy: ['', Validators.required]
    });

    this.cargarDisciplinas();
    this.cargarAlergiaGravedad();

  
  }

  //Nos suscribimos al servicio de gestión de usuarios para crear el alumno y redirigirnos a la ruta de gestión de usuarios
  crearAlumno (){

    this.alumno.username = this.alumnoForm.controls.username.value;
    this.alumno.password = this.alumnoForm.controls.password.value;
    this.alumno.name = this.alumnoForm.controls.name.value;
    this.alumno.surnames = this.alumnoForm.controls.surnames.value;
    this.alumno.birthdate = this.alumnoForm.controls.birthdate.value;
    this.alumno.curp = this.alumnoForm.controls.curp.value;
    this.alumno.tlf = this.alumnoForm.controls.tlf.value;
    this.alumno.address = this.alumnoForm.controls.address.value;
    this.alumno.email = this.alumnoForm.controls.email.value;
    this.alumno.contact = this.alumnoForm.controls.contact.value;
    this.alumno.discipline = this.alumnoForm.controls.discipline.value;
    this.alumno.allergy = this.alumnoForm.controls.allergy.value;
    
    
    this.gestionUsuarioService.crearAlumno(this.alumno).subscribe((alumno: any) => {
      Swal.fire(`El alumno ${this.alumno.name} ha sido creado correctamente`)
      this.router.navigate(['/gestionUsuarios']);
    });
  };

  // Cargar las disciplinas
  cargarDisciplinas(){
    this.gestionUsuarioService.getListaDisciplinas().subscribe((disciplinas: Disciplina[]) => {
     
      this.disciplinas = disciplinas;
    })
  }

  // Cargar la gravedad de las alérgias
  cargarAlergiaGravedad(){
    this.gestionUsuarioService.getListAlergiaGravedad().subscribe((alergiaGravedad: AlergiaGravedad[]) => {
    
      this.alergiaGravedad = alergiaGravedad;
    })
  }
}

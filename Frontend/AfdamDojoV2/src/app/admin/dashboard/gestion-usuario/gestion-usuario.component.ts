import { Component,AfterViewInit, ViewChild, OnInit } from '@angular/core';

import { Alumno } from '../interfaces/Alumno';
import { Profesor } from '../interfaces/Profesor';

import { GestionUsuarioService } from '../services/gestion-usuario.service';

import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';



@Component({
  selector: 'app-gestion-usuario',
  templateUrl: './gestion-usuario.component.html',
  styleUrls: ['./gestion-usuario.component.scss']
})
export class GestionUsuarioComponent implements OnInit,AfterViewInit {

    alumnos: Alumno[] = [];
    profesores: Profesor[] = []; 
  
  constructor(private gestionUsuarioService: GestionUsuarioService, private router: Router){}   


  
  /* Tabla con filtro de ordenación */
  
  //Variables
  displayedColumns: string[] = ['name', 'surnames', 'curp', 'more'];



  ngOnInit(): void {
    this.gestionUsuarioService.obtenerAlumnos().subscribe(alumnos => this.alumnos = alumnos);
    this.gestionUsuarioService.obtenerProfesores().subscribe(profesores => this.profesores = profesores);
  }

  //@ViewChild(MatSort) sort: MatSort;

  ngAfterViewInit () {
    //this.dataSource.sort = this.sort;
  }

  detalles(){
    
  }

}

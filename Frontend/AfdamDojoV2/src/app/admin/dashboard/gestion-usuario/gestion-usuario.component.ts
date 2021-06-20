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
export class GestionUsuarioComponent implements OnInit {

    alumnos: Alumno[] = [];
    profesores: Profesor[] = []; 
  
  constructor(private gestionUsuarioService: GestionUsuarioService, private router: Router){}   


  ngOnInit(): void {
    
  }


 

}

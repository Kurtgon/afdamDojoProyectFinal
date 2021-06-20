import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';

import { MatSort }from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

import { GestionUsuarioService } from '../../services/gestion-usuario.service';

import { environment } from '../../../../../environments/environment';


import { Router } from '@angular/router';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.scss']
})
export class AlumnosComponent implements OnInit, AfterViewInit {

  //Variables
  curp:string;

  // Para mostrar los campos de cabecera de las columnas
  displayedColumns: string[] = ['name', 'surnames', 'curp', 'more'];

  //Creamos un dataSource para los datos del alumno
  dataSourceAlumno = new MatTableDataSource();

  //Incluimos el paginator de material
  @ViewChild(MatPaginator, {static: true }) paginator: MatPaginator;

  //Incluimos la ordenación de los campos con el método sort de material
  @ViewChild(MatSort, {static: true }) sort: MatSort;

  constructor(private gestionUsuarioService : GestionUsuarioService, private router: Router) { }

  ngOnInit(): void {
    // Obtenemos todos los datos de los alumnos
    this.gestionUsuarioService.obtenerAlumnos().subscribe(alumnos => this.dataSourceAlumno.data = alumnos);
    // Obtener la curp del alumno
    //this.curp = this.gestionUsuarioService.getCurp(this.curp);
  }

  ngAfterViewInit(){

    // Una vez cargada los datos de los alumnos cargamos el paginator y la ordenación de esos datos
    this.dataSourceAlumno.paginator = this.paginator;
    this.dataSourceAlumno.sort = this.sort;
  }

  // Método para filtrar los valores de los datos del alumno y pasarlo a minúsculas por si hacemos una búsqueda
  applyFilter(filterValue: string){
    this.dataSourceAlumno.filter = filterValue.trim().toLowerCase();
  }

  // Detalles del alumno
  detallesAlumno(curp:string){
    const url = `${environment.alumnoUrl}`;
    this.gestionUsuarioService.setCurp(this.curp);
    this.router.navigate([`url/${curp}`]);
  }

}

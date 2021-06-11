import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';

import {MatSort} from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon'; 

import { GestionUsuarioService } from '../../services/gestion-usuario.service';

import { Alumno } from '../../interfaces/Alumno';
import { Profesor } from '../../interfaces/Profesor';
import { Router } from '@angular/router';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['name', 'surnames', 'curp', 'more'];
  dataSourceAlumno = new MatTableDataSource();
  dataSourceProfesor = new MatTableDataSource();

  @ViewChild(MatPaginator, {static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true }) sort: MatSort;

 


  constructor(private gestionUsuarioService : GestionUsuarioService, private router: Router) { }

  ngOnInit(): void {

    this.gestionUsuarioService.obtenerAlumnos().subscribe(alumnos => this.dataSourceAlumno.data = alumnos);
    this.gestionUsuarioService.obtenerProfesores().subscribe(profesores => this.dataSourceProfesor.data = profesores);

  }

  ngAfterViewInit() {
    
    this.dataSourceAlumno.paginator = this.paginator;
    this.dataSourceAlumno.sort = this.sort;

    this.dataSourceProfesor.paginator = this.paginator;
    this.dataSourceProfesor.sort = this.sort;

  }

  applyFilter(filterValue: string){
    this.dataSourceAlumno.filter = filterValue.trim().toLowerCase();
    this.dataSourceProfesor.filter = filterValue.trim().toLowerCase();
  }

  onNewAlumno(){}

  onNewProfesor(){}
}

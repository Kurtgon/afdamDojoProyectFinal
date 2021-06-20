import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';

import { MatSort }from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

import { GestionUsuarioService } from '../../services/gestion-usuario.service';

import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-profesores',
  templateUrl: './profesores.component.html',
  styleUrls: ['./profesores.component.scss']
})
export class ProfesoresComponent implements OnInit, AfterViewInit {

   //Variables
   curp:string;

  // Para mostrar los campos de cabecera de las columnas
  displayedColumns: string[] = ['name', 'surnames', 'curp', 'more'];

  //Creamos un dataSource para los datos del profesor
  dataSourceProfesor = new MatTableDataSource();
  
  //Incluimos el paginator de material
  @ViewChild(MatPaginator, {static: true }) paginator: MatPaginator;

  //Incluimos la ordenación de los campos con el método sort de material
  @ViewChild(MatSort, {static: true }) sort: MatSort;
  
  constructor(private gestionUsuarioService : GestionUsuarioService, private router: Router) { }

  ngOnInit(): void {
     // Obtenemos todos los datos de los profesores
    this.gestionUsuarioService.obtenerProfesores().subscribe(profesores => this.dataSourceProfesor.data = profesores);
  }

  ngAfterViewInit(){
  
    // Una vez cargada los datos de los datos de los profesores cargarmos el paginator y la ordenación
    this.dataSourceProfesor.paginator = this.paginator;
    this.dataSourceProfesor.sort = this.sort;
  }

   // Método para filtrar los valores de los datos del alumno y pasarlo a minúsculas por si hacemos una búsqueda
   applyFilter(filterValue: string){
    this.dataSourceProfesor.filter = filterValue.trim().toLowerCase();
   }

   // Detalles del profesor
   detallesProfesor(curp:string){
     const url = `${environment.profesorUrl}`;
     this.gestionUsuarioService.setCurp(this.curp);
     this.router.navigate([`url/${curp}`]);
   }

}

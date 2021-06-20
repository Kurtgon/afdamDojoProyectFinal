import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Alumno } from '../../interfaces/Alumno';

import { GestionUsuarioService } from '../../services/gestion-usuario.service';

@Component({
  selector: 'app-detalles-alumno',
  templateUrl: './detalles-alumno.component.html',
  styleUrls: ['./detalles-alumno.component.scss']
})
export class DetallesAlumnoComponent implements OnInit {

  alumno = new Alumno();
  
  curp: string;

  constructor(private router: Router, private gestionUsuarioService: GestionUsuarioService, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let curp = this.activeRoute.snapshot.paramMap.get('curp');
  
    this.gestionUsuarioService.obtenerAlumno(curp).subscribe((curp: Alumno) => {
      this.alumno = curp;
    });
  }

  
  
  baja(){
    let curp = this.activeRoute.snapshot.paramMap.get('curp');
    this.gestionUsuarioService.deleteAlumno(curp).subscribe((curp: Alumno) => {
      this.alumno = curp;
    })
  }
  modificar(){}
}

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';

import { Alumno } from '../../interfaces/Alumno';

import { GestionUsuarioService } from '../../services/gestion-usuario.service';

@Component({
  selector: 'app-actualizar-alumno',
  templateUrl: './actualizar-alumno.component.html',
  styleUrls: ['./actualizar-alumno.component.scss']
})
export class ActualizarAlumnoComponent implements OnInit {

  alumno = new Alumno();

  curp: string;

  constructor(private router:Router, private gestionUsuarioService: GestionUsuarioService, private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {

    let curp = this.activeRoute.snapshot.paramMap.get('curp');

    this.gestionUsuarioService.obtenerAlumno(curp).subscribe((curp:Alumno)=> {
      this.alumno = curp;
    });
  }

}

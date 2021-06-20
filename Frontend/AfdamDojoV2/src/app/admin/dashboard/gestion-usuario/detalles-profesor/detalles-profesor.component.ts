import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Profesor } from '../../interfaces/Profesor';

import { GestionUsuarioService } from '../../services/gestion-usuario.service';

@Component({
  selector: 'app-detalles-profesor',
  templateUrl: './detalles-profesor.component.html',
  styleUrls: ['./detalles-profesor.component.scss']
})
export class DetallesProfesorComponent implements OnInit {

  profesor = new Profesor();

  curp:string;

  constructor(private router: Router, private gestionUsuarioService: GestionUsuarioService, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {

    let curp = this.activeRoute.snapshot.paramMap.get('curp');

    this.gestionUsuarioService.obtenerProfesor(curp).subscribe((curp: Profesor) => {

      this.profesor = curp;
    })
  }


  baja(){}
  modificar(){}

}

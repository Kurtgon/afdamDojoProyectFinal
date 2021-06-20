import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { HomeComponent } from './home/home.component';
import { GestionUsuarioComponent } from './gestion-usuario/gestion-usuario.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

import { MatTableModule } from '@angular/material/table';

import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';
import { NuevoAlumnoComponent } from './gestion-usuario/nuevo-alumno/nuevo-alumno.component';
import { AlumnosComponent } from './gestion-usuario/alumnos/alumnos.component';
import { ProfesoresComponent } from './gestion-usuario/profesores/profesores.component';
import { NuevoProfesorComponent } from './gestion-usuario/nuevo-profesor/nuevo-profesor.component';
import { DetallesAlumnoComponent } from './gestion-usuario/detalles-alumno/detalles-alumno.component';
import { DetallesProfesorComponent } from './gestion-usuario/detalles-profesor/detalles-profesor.component';
import { ActualizarAlumnoComponent } from './gestion-usuario/actualizar-alumno/actualizar-alumno.component';



@NgModule({
  declarations: [
    HomeComponent,
    GestionUsuarioComponent,
    NuevoAlumnoComponent,
    AlumnosComponent,
    ProfesoresComponent,
    NuevoProfesorComponent,
    DetallesAlumnoComponent,
    DetallesProfesorComponent,
    ActualizarAlumnoComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FlexLayoutModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatIconModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class DashboardModule { }

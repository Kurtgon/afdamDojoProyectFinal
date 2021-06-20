import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {GestionUsuarioComponent} from './gestion-usuario/gestion-usuario.component';
import { AlumnosComponent } from './gestion-usuario/alumnos/alumnos.component';
import { NuevoAlumnoComponent } from './gestion-usuario/nuevo-alumno/nuevo-alumno.component';
import { ActualizarAlumnoComponent } from './gestion-usuario/actualizar-alumno/actualizar-alumno.component';
import { DetallesAlumnoComponent } from './gestion-usuario/detalles-alumno/detalles-alumno.component';
import { ProfesoresComponent } from './gestion-usuario/profesores/profesores.component';
import { NuevoProfesorComponent } from './gestion-usuario/nuevo-profesor/nuevo-profesor.component';
import { DetallesProfesorComponent } from './gestion-usuario/detalles-profesor/detalles-profesor.component';


const routes: Routes = [
  
  { path:'', component: HomeComponent },
  { path:'gestionUsuarios', component: GestionUsuarioComponent},
  { path: 'alumnos', component: AlumnosComponent},
  { path: 'nuevoAlumno', component: NuevoAlumnoComponent},
  { path: 'actualizarAlumno/:curp', component:ActualizarAlumnoComponent},
  { path: 'detallesAlumno/:curp', component: DetallesAlumnoComponent},
  { path: 'profesores' , component: ProfesoresComponent},
  { path: 'nuevoProfesor', component: NuevoProfesorComponent},
  { path: 'detallesProfesor/:curp', component: DetallesProfesorComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }

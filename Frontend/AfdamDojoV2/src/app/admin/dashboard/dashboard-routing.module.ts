import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {GestionUsuarioComponent} from './gestion-usuario/gestion-usuario.component'

const routes: Routes = [
  
  { path:'', component: HomeComponent },
  { path:'gestionUsuarios', component: GestionUsuarioComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }

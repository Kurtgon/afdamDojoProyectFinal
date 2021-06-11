import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { PanelAdminComponent } from './pages/dashboard/components/panel-admin/panel-admin.component';

const routes: Routes = [

  
  { path:'panelAdmin', component: PanelAdminComponent},
  { path:'login', component:LoginComponent },
  { path:'', redirectTo:'login', pathMatch:'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

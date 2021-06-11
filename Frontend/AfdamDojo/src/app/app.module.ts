import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';

import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import {MatMenuModule} from '@angular/material/menu';

import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';


import { SidenavComponent } from './pages/dashboard/components/sidenav/sidenav.component'; 
import { PanelAdminComponent } from './pages/dashboard/components/panel-admin/panel-admin.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { RegisterComponent } from './auth/register/register.component';
import { NotfoundComponent } from './pages/notfound/notfound.component';

import { BreadcrumbsComponent } from './common/breadcrumbs/breadcrumbs.component';
import { SidebarComponent } from './common/sidebar/sidebar.component';
import { HeaderComponent } from './common/header/header.component';
import { DashboardAdminComponent } from './pages/dashboard/components/dashboard-admin/dashboard-admin.component';
import { ToolbarComponent } from './pages/dashboard/components/toolbar/toolbar.component';  


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PanelAdminComponent,
    SidenavComponent,
    RegisterComponent,
    NotfoundComponent,
  
    BreadcrumbsComponent,
    SidebarComponent,
    HeaderComponent,
    DashboardAdminComponent,
    ToolbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,
    MatToolbarModule,
    MatMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }

import { Component, OnInit } from '@angular/core';

//Crear la interface de las tarjetas

interface HomeCard {
  img: string;
  name: string;

}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  items: Array<HomeCard>= [];

  constructor() { }

  ngOnInit(): void {
    
    this.items = [{
      img: 'assets/gestion_usuario_01.jpg',
      name: 'Gestión de Usuarios'
    },
    {
      img: 'assets/notificaciones_02.jpg',
      name: 'Notificaciones'
    },
    {
      img: 'assets/promociones_02.jpg',
      name: 'Promociones'
    },
    {
      img: 'assets/shop_02.jpg',
      name: 'Gestión del Catálogo'
    }]
  
  }

}

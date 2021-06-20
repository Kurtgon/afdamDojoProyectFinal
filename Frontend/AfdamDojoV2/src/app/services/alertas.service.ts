import { Injectable } from '@angular/core';
import { MatDialogConfig, MatDialog } from '@angular/material/dialog';

import { Observable } from 'rxjs';
import { DialogoComponent } from '../dialogo/dialogo.component';
import { DialogTypes } from '../dialogo/dialogoInterface';


@Injectable({
  providedIn: 'root'
})
export class AlertasService {

  dialogConfig = new MatDialogConfig();

  // Para mostrar en pantalla un dialogo necesito un componente de tipo MatDialog
  constructor(private dialog: MatDialog) {
    
    // Para que no se cierre automáticamente el diálogo
    this.dialogConfig.disableClose=true;
    this.dialogConfig.autoFocus = true;
   }

   // Método para crear una animación con el componente spinner
   abrirDialogCargando(){
     //Nos aseguramos que cierre antes cualquier diálogo que estuviera abierto
     this.cerrarDialogo();
     this.dialogConfig.data = {
      tipoDialogo: DialogTypes.ESPERANDO
     };
     // Abre el diálogo
     this.dialog.open( DialogoComponent, this.dialogConfig);
   }

   // Método para cerrar el diálogo
   cerrarDialogo(){
     this.dialog.closeAll();
   }

   // Método para mostrar un diálogo de error
   abrirDialogoError(textoDeError: string) {
     //Nos aseguramos que cierre antes cualquier diálogo que estuviera abierto
     this.cerrarDialogo();
     this.dialogConfig.data = {
      tipoDialogo: DialogTypes.ERROR,
      texto: textoDeError
     };
     this.dialog.open( DialogoComponent, this.dialogConfig);
   }

   // Método para mostrar información
   abrirDialogInfo(textoDeInfo: string): Observable<number> {
    this.cerrarDialogo();
    this.dialogConfig.data = {  
      tipoDialogo: DialogTypes.INFORMACION,
      texto: textoDeInfo
    };
    // Abro el diálogo pero obtengo una referencia al mismo.
    const dialogRef = this.dialog.open( DialogoComponent, this.dialogConfig);
     // Devuelvo el evento "afterClosed", que permite subscripción
     return dialogRef.afterClosed();
  }

  // Método para confirmar un mensaje
  abrirDialogConfirmacion (textoDeConfirmacion: string): Observable<number> {
    this.cerrarDialogo();
    this.dialogConfig.data = {
      tipoDialogo: DialogTypes.CONFIRMACION,
      texto: textoDeConfirmacion
    };
    const dialogRef = this.dialog.open(DialogoComponent, this.dialogConfig);
    return dialogRef.afterClosed();
  }


}

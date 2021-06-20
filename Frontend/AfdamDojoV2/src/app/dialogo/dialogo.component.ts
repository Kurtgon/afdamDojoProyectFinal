import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DialogType, DialogTypes} from './dialogoInterface';

@Component({
  selector: 'app-dialogo',
  templateUrl: './dialogo.component.html',
  styleUrls: ['./dialogo.component.scss']
})
export class DialogoComponent implements OnInit {

  public dialogTypeClass = DialogTypes;

  constructor(@Inject(MAT_DIALOG_DATA)public data: DialogType) { }

  ngOnInit(): void {
  }

}

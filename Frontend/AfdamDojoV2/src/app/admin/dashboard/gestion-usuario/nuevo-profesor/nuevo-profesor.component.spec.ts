import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoProfesorComponent } from './nuevo-profesor.component';

describe('NuevoProfesorComponent', () => {
  let component: NuevoProfesorComponent;
  let fixture: ComponentFixture<NuevoProfesorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NuevoProfesorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NuevoProfesorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

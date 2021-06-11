import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from, Observable, of} from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { MessageService } from './message.service';

import { Profesor } from '../interfaces/Profesor';
import { Alumno } from '../interfaces/Alumno';


@Injectable({
  providedIn: 'root'
})
export class GestionUsuarioService {

  private alumnoUrl = 'http://localhost:8080/alumno';
  private profesorUrl = 'http://localhost:8080/profesor';

  constructor(private http: HttpClient, private messageService: MessageService) { 
  }

  // SERVICIOS CRUD ALUMNOS

  //Obtener a los alumnos desde el servidor
  obtenerAlumnos():Observable<Alumno[]>{
    return this.http.get<Alumno[]>(this.alumnoUrl).pipe(
      tap(_=> this.log('alumnos buscados')),
      catchError(this.resolverError<Alumno[]>('obtener Alumno', []))
    );
  }

  //Obtener a un alumno por la CURP desde el servidor
  obtenerAlumno(curp: string):Observable<Alumno> {
    const url = `${this.alumnoUrl}/${curp}`;
    return this.http.get<Alumno>(url).pipe(
      tap(_ => this.log(`alumno buscado con curp=${curp}`)),
      catchError(this.resolverError<Alumno>(`obtener Alumno con curp=${curp}`))
    );
  }

  //Actualizar el alumno desde el servidor
  updateAlumno(alumno: Alumno): Observable<any> {
    return this.http.put(this.alumnoUrl, alumno).pipe(
      tap(_ => this.log(`actualizado el alumno con la curp=${alumno.curp}`)),
      catchError(this.resolverError<any>('Actualizado el alumno'))
    );
  }
  
// SERVICIOS CRUD PROFESORES

  //Obtener a los profesores desde el servidor
  obtenerProfesores():Observable<Profesor[]>{
    return this.http.get<Profesor[]>(this.profesorUrl).pipe(
      tap(_=> this.log('profesores buscados')),
      catchError(this.resolverError<Profesor[]>('obtener Profesor', []))
    );
  }

  //Obtener a un profesor por la CURP desde el servidor
  obtenerProfesor(curp: string):Observable<Profesor> {
    const url = `${this.profesorUrl}/${curp}`;
    return this.http.get<Profesor>(url).pipe(
      tap(_ => this.log(`profesor buscado con curp=${curp}`)),
      catchError(this.resolverError<Profesor>(`obtener Profesor con curp=${curp}`))
    );
  }

  //Actualizar el profesor desde el servidor
  updateProfesor(profesor: Profesor): Observable<any> {
    return this.http.put(this.profesorUrl, profesor).pipe(
      tap(_ => this.log(`actualizado el profesor con la curp=${profesor.curp}`)),
      catchError(this.resolverError<any>('Actualizado el profesor'))
    );
  }


  private log(message: string){
    this.messageService.add(`AlumnoService: ${message}`);
  }

  private resolverError<T>(operation = 'operation', result?:T) {
    return (error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of (result as T);
    };
  }

}

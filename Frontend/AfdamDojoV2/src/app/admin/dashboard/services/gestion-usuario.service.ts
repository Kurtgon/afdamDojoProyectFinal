import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from, Observable, of} from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { MessageService } from './message.service';

import { Profesor } from '../interfaces/Profesor';
import { Alumno } from '../interfaces/Alumno';

import { environment } from '../../../../environments/environment';
import { Disciplina } from '../interfaces/Disciplina';
import { AlergiaGravedad } from '../interfaces/AlergiaGravedad';


@Injectable({
  providedIn: 'root'
})
export class GestionUsuarioService {

  private alumnoUrl = 'http://localhost:8080/alumno';
  private profesorUrl = 'http://localhost:8080/profesor';

  curp:string;

  constructor(private http: HttpClient, private messageService: MessageService) { 
  }

  // SERVICIOS CRUD ALUMNOS

  //Obtener a los alumnos desde el servidor
  obtenerAlumnos():Observable<Alumno[]>{
    return this.http.get<Alumno[]>(environment.alumnoUrl).pipe(
      tap(_=> this.log('alumnos buscados')),
      catchError(this.resolverError<Alumno[]>('obtener Alumno', []))
    );
  }

  //Obtener a un alumno por la CURP desde el servidor
  obtenerAlumno(curp: string):Observable<Alumno> {
    const url = `${environment.alumnoUrl}/${curp}`;
    return this.http.get<Alumno>(url).pipe(
      tap(_ => this.log(`alumno buscado con curp=${curp}`)),
      catchError(this.resolverError<Alumno>(`obtener Alumno con curp=${curp}`))
    );
  }

  //Actualizar el alumno desde el servidor
  updateAlumno(curp: string, alumno:Alumno): Observable<Alumno> {
    const url = `${environment.alumnoUrl}/${curp}`;
    return this.http.put<Alumno>(url,alumno).pipe(
      tap(_ => this.log(`actualizado el alumno con la curp=${curp}`)),
      catchError(this.resolverError<any>('Actualizado el alumno'))
    );
  }

  // Eliminar a un alumno
  deleteAlumno(curp: string): Observable<Alumno>{
    return this.http.delete<Alumno>(environment.alumnoUrl + curp);
  }

  //Creamos un alumno desde el servidor
  crearAlumno(alumno: Alumno): Observable<any>{
    return this.http.post(environment.signUpUrlAlumno, alumno).pipe(
      tap(_ => this.log('nuevo alumno creado con nombre')),
      catchError(this.resolverError<Alumno>('Nuevo alumno creado'))
    );
  }
  
// SERVICIOS CRUD PROFESORES

  //Obtener a los profesores desde el servidor
  obtenerProfesores():Observable<Profesor[]>{
    return this.http.get<Profesor[]>(environment.profesorUrl).pipe(
      tap(_=> this.log('profesores buscados')),
      catchError(this.resolverError<Profesor[]>('obtener Profesor', []))
    );
  }

  //Obtener a un profesor por la CURP desde el servidor
  obtenerProfesor(curp: string):Observable<Profesor> {
    const url = `${environment.profesorUrl}/${curp}`;
    return this.http.get<Profesor>(url).pipe(
      tap(_ => this.log(`profesor buscado con curp=${curp}`)),
      catchError(this.resolverError<Profesor>(`obtener Profesor con curp=${curp}`))
    );
  }

  //Actualizar el profesor desde el servidor
  updateProfesor(profesor: Profesor): Observable<any> {
    return this.http.put(environment.profesorUrl, profesor).pipe(
      tap(_ => this.log(`actualizado el profesor con la curp=${profesor.curp}`)),
      catchError(this.resolverError<any>('Actualizado el profesor'))
    );
  }

  // Creamos al profesor desde el servidor
  crearProfesor(profesor: Profesor): Observable<any>{
    return this.http.post(environment.signUpUrlProfesor, profesor).pipe(
      tap(_ => this.log('nuevo profesor creado')),
      catchError(this.resolverError<Alumno>('Nuevo profesor creado'))
    );
  }

  //Nos traemos las disciplinas desde el servidor
  getListaDisciplinas():Observable<Disciplina[]>{
    return this.http.get<Disciplina[]>(environment.endpointDisciplinas);
  }

  //Nos traemos todos los niveles de gravedad de la alergia
  getListAlergiaGravedad():Observable<AlergiaGravedad[]>{
    return this.http.get<AlergiaGravedad[]>(environment.endpointAlergiaGravedad);
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

  setCurp(curp:string){
    return this.curp;
  }

}

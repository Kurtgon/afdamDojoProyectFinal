// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  signUpUrlAlumno:"http://localhost:8080/user/sign-up/alumno",
  signUpUrlProfesor:"http://localhost:8080/user/sign-up/profesor",
  loginUrl:"http://localhost:8080/user/login",
  alumnoUrl:"http://localhost:8080/alumno",
  profesorUrl:"http://localhost:8080/profesor",
  endpointDisciplinas:"http://localhost:8080/disciplinas",
  endpointAlergiaGravedad:"http://localhost:8080/alergiasgravedad"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.

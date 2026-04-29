/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.RestController;

import equipopokeapi.service.Ml.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Alien 7
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> manejoExcepcionGeneral(Exception ex){
    
        Result error = new Result();
        error.correct = false;
        error.errorMessage = "Hubo un problema con el servidor: " + ex.getLocalizedMessage();
        error.ex = ex;
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Result> manejoMetodoNoPermitido(HttpRequestMethodNotSupportedException ex){
    
        Result error = new Result();
        error.correct = false;
        error.errorMessage = "El método: " + ex.getMethod() + " no tiene soporte.";
        error.ex = ex;
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    
    }
        
}

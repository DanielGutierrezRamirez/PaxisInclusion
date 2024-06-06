package ies.torredelrey.controlador.exceptions;

/**
 * Excepción NonexistentEntityException para manejar entidades inexistentes.
 * Esta excepción se utiliza cuando se intenta acceder a una entidad que no existe.
 * 
 * @version 1.0
 * @autor Daniel Gutierrez Ramirez
 */
public class NonexistentEntityException extends Exception {
    
    /**
     * Constructor que acepta un mensaje de error y una causa.
     * 
     * @param message Mensaje de error.
     * @param cause Causa de la excepción.
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructor que acepta un mensaje de error.
     * 
     * @param message Mensaje de error.
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
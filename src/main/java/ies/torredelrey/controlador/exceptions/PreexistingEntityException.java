package ies.torredelrey.controlador.exceptions;

/**
 * Excepción PreexistingEntityException para manejar entidades preexistentes.
 * Esta excepción se utiliza cuando se intenta crear una entidad que ya existe.
 * 
 * @version 1.0
 * @autor Daniel Gutierrez Ramirez
 */
public class PreexistingEntityException extends Exception {
    
    /**
     * Constructor que acepta un mensaje de error y una causa.
     * 
     * @param message Mensaje de error.
     * @param cause Causa de la excepción.
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructor que acepta un mensaje de error.
     * 
     * @param message Mensaje de error.
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}

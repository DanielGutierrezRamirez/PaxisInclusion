package ies.torredelrey.controlador.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Excepción IllegalOrphanException para manejar errores de orfandad ilegal.
 * Esta excepción se utiliza cuando una entidad no puede ser eliminada debido a 
 * referencias de otras entidades que dependen de ella.
 * 
 * @version 1.0
 * @autor Daniel Gutierrez Ramirez
 */
public class IllegalOrphanException extends Exception {
    
    private List<String> messages;

    /**
     * Constructor que acepta una lista de mensajes de error.
     * 
     * @param messages Lista de mensajes de error.
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && !messages.isEmpty() ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<>();
        } else {
            this.messages = messages;
        }
    }

    /**
     * Obtiene la lista de mensajes de error.
     * 
     * @return Lista de mensajes de error.
     */
    public List<String> getMessages() {
        return messages;
    }
}

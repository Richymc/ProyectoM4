package org.bedu.APIStreaming.exception;

public class MovieNotFoundException extends RuntimeException{
    
    public MovieNotFoundException(long id){
        super("ERR_MOV_NOT_FOUND", "La pelicula no existe", id);
    }
}

package org.bedu.APIStreaming.exception;

public class MovieNotFoundException extends RuntimeException{
    
    public MovieNotFoundException(long id){
        super( "La pelicula no existe", "ERR_MOV_NOT_FOUND", id);
    }
}

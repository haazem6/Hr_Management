package net.javaguides.emsbackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotfoundException extends RuntimeException{

    public RessourceNotfoundException(String message){


    }
}

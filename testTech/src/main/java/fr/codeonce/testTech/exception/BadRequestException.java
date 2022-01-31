package fr.codeonce.testTech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BadRequestException extends  RuntimeException {

    public BadRequestException(String exception){
        super(exception);
    }
}

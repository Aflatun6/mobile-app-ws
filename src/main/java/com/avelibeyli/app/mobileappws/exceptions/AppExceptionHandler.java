package com.avelibeyli.app.mobileappws.exceptions;

import com.avelibeyli.app.mobileappws.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

//        String errorMessageDescription = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.getMessage();
//        ErrorMessage errorMessage = new ErrorMessage();
//        errorMessage.setMessage(errorMessageDescription);
//        errorMessage.setTimestamp(new Date());
//
//        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

        return getResponseObjectEntity(ex);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
//        String errorMessageDescription = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.getMessage();
//        ErrorMessage errorMessage = new ErrorMessage();
//        errorMessage.setMessage(errorMessageDescription);
//        errorMessage.setTimestamp(new Date());
//
//        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//
        return getResponseObjectEntity(ex);
    }

    private ResponseEntity<Object> getResponseObjectEntity(Exception ex) {
        String errorMessageDescription = ex.getLocalizedMessage() != null ? ex.getLocalizedMessage() : ex.getMessage();
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(errorMessageDescription);
        errorMessage.setTimestamp(new Date());

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }


}

package com.mx.tec.people.advisor;

import com.mx.tec.people.common.models.CommonError;
import com.mx.tec.people.exception.BusinessException;
import com.mx.tec.people.exception.InternalServerErrorException;
import com.mx.tec.people.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CommonError> handleEmptyResultConflict(RecordNotFoundException ex) {
        CommonError error = new CommonError(ex.getError(), ex.getProcess(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CommonError> handleInternalException(InternalServerErrorException ex) {
        CommonError error = new CommonError(ex.getError(), ex.getProcess(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CommonError> handleConflictException(BusinessException ex) {
        CommonError error = new CommonError(ex.getError(), ex.getProcess(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

}

package com.mx.tec.people.exception;


public class InternalServerErrorException extends PeopleDataException {

    public InternalServerErrorException(String message, String process) {
        super(message, process);
    }

    public InternalServerErrorException(String message, String process, String error) {
        super(message, process, error);
    }


}

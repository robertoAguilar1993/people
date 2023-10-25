package com.mx.tec.people.exception;


import java.util.Arrays;
import java.util.List;

public class PeopleDataException extends RuntimeException {

    private String error;
    private String process;

    public PeopleDataException(String error) {
        this.error = error;
    }


    public PeopleDataException(String message, String process, String error) {
        super(message);
        this.error = error;
        this.process = process;
    }

    public PeopleDataException(String message, String error) {
        super(message);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}

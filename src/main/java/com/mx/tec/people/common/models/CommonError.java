package com.mx.tec.people.common.models;



import java.io.Serializable;


public class CommonError implements Serializable {

    public CommonError() {
    }

    public CommonError(String errors, String process) {
        this.errors = errors;
        this.process = process;
    }

    public CommonError(String errors, String process, String message) {
        this.errors = errors;
        this.process = process;
        this.message = message;
    }

    private String errors;

    private String process;

    private String message;

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

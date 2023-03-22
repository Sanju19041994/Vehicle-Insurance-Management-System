package com.shruteekaTech.VIMS.exception;

public class ResourceNotFoundException extends RuntimeException{

    String resource;
    String fieldName;


    public ResourceNotFoundException(String resource, String fieldName) {
        super(String.format("%s not found with given %s",resource,fieldName));
        this.resource = resource;
        this.fieldName = fieldName;

    }
}

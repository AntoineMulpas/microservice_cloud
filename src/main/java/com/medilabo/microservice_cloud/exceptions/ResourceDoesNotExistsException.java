package com.medilabo.microservice_cloud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceDoesNotExistsException extends RuntimeException{

    public ResourceDoesNotExistsException(String message) {
        super(message);
    }
}

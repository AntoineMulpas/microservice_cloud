package com.medilabo.microservice_cloud.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder decoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 409) {
            return  new ResourceAlreadyExistsException("Resource already exists.");
        }

        if (response.status() == 404) {
            return new ResourceDoesNotExistsException("Resource does not exists.");
        }

        return decoder.decode(s, response);
    }
}

package com.devx.service.passon.devxpasson.passon.exception;

import org.apache.commons.configuration.CompositeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PassOnServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private CompositeConfiguration compositeConfiguration;

    private static final String EMAIL_SUCCESS_202 = "passon.service.email.success.202";
    private static final String EMAIL_ERR = "passon.service.email.error.";

    @ExceptionHandler(PassOnServiceEmailException.class)
    public final ResponseEntity<PassOnApiErrorResponse> handleEmailErrorResponse(
            final PassOnServiceEmailException ex, final WebRequest webRequest) {

        final String status = String.valueOf(ex.getStatus());
        final String statusCode = EMAIL_ERR + status;
        PassOnApiErrorResponse errorResponse =
                new PassOnApiErrorResponse("EMAIL_ERR_" + status, String.valueOf(compositeConfiguration.getProperty(statusCode)));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

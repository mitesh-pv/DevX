package com.devx.service.passon.devxpasson.passon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PassOnServiceEmailException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer status;

    public PassOnServiceEmailException(final Integer status){
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }
}

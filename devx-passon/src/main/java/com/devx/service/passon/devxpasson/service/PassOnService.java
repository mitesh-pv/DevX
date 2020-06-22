package com.devx.service.passon.devxpasson.service;

import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailRequestDto;

import java.io.IOException;

public interface PassOnService {

    String PASSON_SERVICE_API_KEY = "passon.service.sendgrid.api.key";
    String PASSON_SERVICE_SENDER_EMAIL = "passon.service.sendgrid.api.senderemail";

    public String verifyUserByEmail(final VerifyUserByEmailRequestDto verifyUserByEmailRequestDto) throws IOException;

}
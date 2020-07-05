package com.devx.service.passon.devxpasson.service;

import com.devx.service.passon.devxpasson.entity.EmailEntity;
import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailRequestDto;
import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailResponseDto;
import com.sendgrid.Response;

import java.io.IOException;

public interface PassOnService {

    String PASSON_SERVICE_API_KEY = "passon.service.sendgrid.api.key";
    String PASSON_SERVICE_SENDER_EMAIL = "passon.service.sendgrid.api.senderemail";

    String TYPE_HTML = "text/html";
    String DEVX_SERVICE_VERIFY_EMAIL_SUBJECT = "Welcome to DevEx! Verify your email to get started";
    String DEVX_SERVICE_VERIFY_EMAIL_CONTENT = "sdffsf";

    public Response verifyUserByEmail(final VerifyUserByEmailRequestDto verifyUserByEmailRequestDto);

    public Response emailService(final EmailEntity emailEntity) throws IOException;

}
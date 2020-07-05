package com.devx.service.passon.devxpasson.service;

import com.devx.service.passon.devxpasson.entity.EmailEntity;
import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailRequestDto;
import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailResponseDto;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import org.apache.commons.configuration.CompositeConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PassOnServiceImpl implements PassOnService {

    @Autowired
    private CompositeConfiguration compositeConfiguration;

    private String verificationLink;

    private static final Logger LOGGER = LoggerFactory.getLogger(PassOnServiceImpl.class);

    @Override
    public Response verifyUserByEmail(final VerifyUserByEmailRequestDto verifyUserByEmailRequestDto) {

        verificationLink = "This is the email verificationLink";
        final EmailEntity emailEntity = new EmailEntity();
        emailEntity.setSender(String.valueOf(compositeConfiguration.getProperty(PASSON_SERVICE_SENDER_EMAIL)));
        emailEntity.setReceiver(verifyUserByEmailRequestDto.getEmail());
        emailEntity.setSubject(null);
        emailEntity.setContent(TYPE_HTML, verificationLink);
        return emailService(emailEntity);
    }

    @Override
    public Response emailService(final EmailEntity emailEntity) {

        final Mail mail = new Mail(
                emailEntity.getSender(),
                emailEntity.getSubject(),
                emailEntity.getReceiver(),
                emailEntity.getContent()
        );

        final SendGrid sendGrid = new SendGrid(String.valueOf(compositeConfiguration.getProperty(PASSON_SERVICE_API_KEY)));
        final Request emailRequest = new Request();
        Response emailResponse = null;

        try {
            emailRequest.setMethod(Method.POST);
            emailRequest.setEndpoint("mail/send");
            emailRequest.setBody(mail.build());
            emailResponse = sendGrid.api(emailRequest);
            LOGGER.info(" trace = {}, message ={}", "emailService", emailResponse.getStatusCode() + " " + emailResponse.getBody());
        }catch (Exception e) {
            LOGGER.error(" trace = {}, message = {}\n", "emailService", e.getMessage());
        }finally {
            return emailResponse;
        }
    }

}

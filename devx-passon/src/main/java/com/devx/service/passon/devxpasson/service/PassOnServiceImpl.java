package com.devx.service.passon.devxpasson.service;

import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailRequestDto;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PassOnServiceImpl implements PassOnService {

    @Autowired
    private CompositeConfiguration compositeConfiguration;

    @Override
    public String verifyUserByEmail(final VerifyUserByEmailRequestDto verifyUserByEmailRequestDto) throws IOException {

        final Email senderEmail = new Email(String.valueOf(compositeConfiguration.getProperty(PASSON_SERVICE_SENDER_EMAIL)));
        final Email receiverEmail = new Email(verifyUserByEmailRequestDto.getEmail());
        final String subject = "Verify your email";
        final Content content = new Content("text/plain", "This is sample mail, do not reply");
        final Mail mail = new Mail(senderEmail, subject, receiverEmail, content);
        final SendGrid sendGrid = new SendGrid(String.valueOf(compositeConfiguration.getProperty(PASSON_SERVICE_API_KEY)));
        final Request request = new Request();

        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            final Response response = sendGrid.api(request);
//            System.out.println(response.getStatusCode() + " " + response.getBody() + " "+ response.getHeaders());






        }catch (IOException exp){
            throw exp;
//            System.out.println("sdfs");
        }

        return "sent";

    }
}

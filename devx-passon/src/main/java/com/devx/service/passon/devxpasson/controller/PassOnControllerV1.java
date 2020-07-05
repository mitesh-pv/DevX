package com.devx.service.passon.devxpasson.controller;

import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailRequestDto;
import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailResponseDto;
import com.devx.service.passon.devxpasson.passon.exception.PassOnServiceEmailException;
import com.devx.service.passon.devxpasson.service.PassOnService;
import com.sendgrid.Response;
import org.apache.commons.configuration.CompositeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/passon")
public class PassOnControllerV1 {

    @Autowired
    private PassOnService passOnService;

    @Autowired
    private CompositeConfiguration compositeConfiguration;

    @RequestMapping(method = RequestMethod.POST, value = "/web/v1/verifyEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VerifyUserByEmailResponseDto> verifyUserByEmail(@RequestBody final VerifyUserByEmailRequestDto verifyUserByEmailRequestDto) {
        final Response emailResponse = passOnService.verifyUserByEmail(verifyUserByEmailRequestDto);
        final VerifyUserByEmailResponseDto verifyUserByEmailResponseDto = handleEmailResponseForException(emailResponse);
        return ResponseEntity.ok(verifyUserByEmailResponseDto);
    }

    private VerifyUserByEmailResponseDto handleEmailResponseForException(final Response emailResponse) {

        final VerifyUserByEmailResponseDto verifyUserByEmailResponseDto = new VerifyUserByEmailResponseDto();
        if(emailResponse == null){
            throw new PassOnServiceEmailException(500);
        }else if(emailResponse.getStatusCode() != 202){
            throw new PassOnServiceEmailException(emailResponse.getStatusCode());
        }

        verifyUserByEmailResponseDto.setEmailSent(true);
        return verifyUserByEmailResponseDto;
    }


}

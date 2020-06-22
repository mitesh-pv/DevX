package com.devx.service.passon.devxpasson.controller;

import com.devx.service.passon.devxpasson.passon.dto.VerifyUserByEmailRequestDto;
import com.devx.service.passon.devxpasson.service.PassOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/passon")
public class PassOnControllerV1 {

    @Autowired
    private PassOnService passOnService;

    @RequestMapping(method = RequestMethod.POST, value = "/web/v1/transmit", produces = MediaType.APPLICATION_JSON_VALUE)
    public String verifyUserByEmail(@RequestBody final VerifyUserByEmailRequestDto verifyUserByEmailRequestDto) {

        try {
            return passOnService.verifyUserByEmail(verifyUserByEmailRequestDto);
        }catch (Exception exp){
            return "error";
        }

    }

}

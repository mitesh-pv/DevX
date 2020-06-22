package com.devx.service.passon.devxpasson.passon.dto;

import com.devx.service.passon.devxpasson.passon.exception.PassOnResponse;

public class VerifyUserByEmailResponseDto extends PassOnResponse {

    private String verificationLink;

    public String getVerificationLink() {
        return verificationLink;
    }

    public void setVerificationLink(String verificationLink) {
        this.verificationLink = verificationLink;
    }
}

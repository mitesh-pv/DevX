package com.devx.service.passon.devxpasson.passon.dto;

public class VerifyUserByEmailResponseDto  {

    private boolean emailSent = false;

    public boolean getVerificationLink() {
        return emailSent;
    }

    public void setEmailSent(final boolean emailSent) {
        this.emailSent = emailSent;
    }
}

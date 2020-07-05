package com.devx.service.passon.devxpasson.entity;

import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class EmailEntity {

    private Email sender;
    private Email receiver;
    private String subject;
    private Content content;

    public Email getSender() {
        return sender;
    }

    public void setSender(final String senderAddress) {
        this.sender = new Email(senderAddress);
    }

    public Email getReceiver() {
        return receiver;
    }

    public void setReceiver(final String receiverAddress) {
        this.receiver = new Email(receiverAddress);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(final String type, final String content) {
        this.content = new Content(type, content);
    }
}

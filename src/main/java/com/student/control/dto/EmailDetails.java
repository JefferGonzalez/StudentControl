package com.student.control.dto;

public class EmailDetails {

    private String recipientAddress;
    private String body;
    private String subject;
    private String attachment;

    /**
     * Devuelve el correo electrónico del receptor
     *
     * @return String
     */
    public String getRecipientAddress() {
        return recipientAddress;
    }

    /**
     * @param recipientAddress Correo electrónico del receptor
     */
    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    /**
     * Devuelve el cuerpo del correo
     *
     * @return String
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body Cuerpo del correo
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Devuelve el asunto del correo
     *
     * @return String
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject Asunto del correo
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Devuelve el path del archivo adjunto
     * @return 
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     * @param attachment Path del archivo adjunto
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

}

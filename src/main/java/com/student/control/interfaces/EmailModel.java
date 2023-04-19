package com.student.control.interfaces;

import com.student.control.dto.EmailDetails;

public interface EmailModel {

    public String sendMail(EmailDetails details);

    public String sendMailWithAttachment(EmailDetails details);
}

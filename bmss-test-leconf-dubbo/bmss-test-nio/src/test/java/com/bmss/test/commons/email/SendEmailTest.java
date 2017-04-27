package com.bmss.test.commons.email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.internet.MimeMultipart;

/**
 * Created by fengxuan1 on 2017/3/24.
 */
public class SendEmailTest {

    private static Logger logger = LoggerFactory.getLogger(SendEmailTest.class);


    @org.junit.Test
    public void sendEmailByImageHtmlEmail(){
        ImageHtmlEmail imageHtmlEmail = new ImageHtmlEmail();
        String userName = "18513372527@163.com";
        String password = "fX12101210";
        imageHtmlEmail.setAuthentication(userName, password);
        MimeMultipart mimeMultipart = null;
        imageHtmlEmail.setContent(mimeMultipart);


        imageHtmlEmail.setHostName("smtp.163.com");
        imageHtmlEmail.setDebug(true);
        String fromUser = "18513372527@163.com";
        String toUser = "lusi486@163.com";

        try {
            EmailAttachment emailAttachment = new EmailAttachment();
            emailAttachment.setPath("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
            emailAttachment.setDescription("picture");
            emailAttachment.setName("菊花");
            emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);

            imageHtmlEmail.attach(emailAttachment);

            imageHtmlEmail.setFrom(fromUser);
            imageHtmlEmail.addTo(toUser);
            imageHtmlEmail.setCharset("GB2312");
            imageHtmlEmail.setSubject("主题");
            imageHtmlEmail.setMsg("附件");
            imageHtmlEmail.send();
            logger.info("success send");
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }

}

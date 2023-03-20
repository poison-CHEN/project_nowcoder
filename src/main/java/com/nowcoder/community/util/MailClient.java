package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * @author Sukie
 * @description 提供发邮件的功能
 * @create 2023-03-17 9:58
 */

@Component
public class MailClient {

    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);
    @Autowired
    private JavaMailSender MailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendmail(String to, String subject, String content)
    {
        try
        {
            MimeMessage mimeMessage = MailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            MailSender.send(helper.getMimeMessage());
        }
        catch(MessagingException e)
        {
            logger.error("发送邮件失败："+ e.getMessage());
        }

    }
}

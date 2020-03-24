
package com.lzycug.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-24
 */
@Service
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendTextMail(String recipient, String subject, String message) {
        // 1.构建一个邮件对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 2.设置邮件主题
        mailMessage.setSubject(subject);
        // 3.设置邮件发送者
        mailMessage.setFrom("510685819@qq.com");
        // 4. 设置邮件接收者，可以有多个接收者
        mailMessage.setTo(recipient);
        /*
         * 5.设置邮件抄送人，可以有多个抄送人
         * mailMessage.setCc("371820637@qq.com");
         * 6.设置隐秘抄送人，可以有多个
         * mailMessage.setBcc("1406134098@qq.com");
         */
        // 7.设置邮件发送日期
        mailMessage.setSentDate(new Date());
        // 8. 设置邮件的正文
        mailMessage.setText(message);
        // 9. 发送邮件
        javaMailSender.send(mailMessage);
    }
}

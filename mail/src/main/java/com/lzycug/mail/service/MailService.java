
package com.lzycug.mail.service;

import com.lzycug.mail.pojo.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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

    public void sendFreemarkerMail(String recipient, String subject, User user)
        throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject(subject);
        helper.setFrom("510685819@qq.com");
        helper.setTo(recipient);
        helper.setSentDate(new Date());

        // 构建 Freemarker 的基本配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        // 配置模板位置
        ClassLoader loader = MailService.class.getClassLoader();
        configuration.setClassLoaderForTemplateLoading(loader, "templates");
        // 加载模板
        Template template = configuration.getTemplate("mail.ftl");
        StringWriter out = new StringWriter();
        // 模板渲染，渲染的结果将被保存到 out 中 ，将out 中的 html 字符串发送即可
        template.process(user, out);
        helper.setText(out.toString(), true);
        javaMailSender.send(mimeMessage);
    }

    public static void main(String[] args) throws Exception {
        // 构建 Freemarker 的基本配置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        // 配置模板位置
        ClassLoader loader = MailService.class.getClassLoader();
        configuration.setClassLoaderForTemplateLoading(loader, "templates");
        // 加载模板
        Template template = configuration.getTemplate("mail.ftl");
        User user = new User();
        user.setUserName("javaboy");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        user.setHireTime(dateFormat.format(new Date()));
        user.setSalary(99999);
        StringWriter out = new StringWriter();
        // 模板渲染，渲染的结果将被保存到 out 中 ，将out 中的 html 字符串发送即可
        template.process(user, out);
        System.out.println(out.toString());
    }
}

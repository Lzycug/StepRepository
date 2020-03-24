
package com.lzycug.mail.controller;

import com.lzycug.mail.pojo.Result;
import com.lzycug.mail.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-24
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @RequestMapping("/sendText")
    public Result sendTextMail(String recipient, String subject, String message) {
        mailService.sendTextMail(recipient, subject, message);
        return Result.SUCCESS;
    }
}

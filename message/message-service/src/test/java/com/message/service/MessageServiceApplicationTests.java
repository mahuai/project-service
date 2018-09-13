package com.message.service;

import com.message.api.entity.request.SendEmailRequest;
import com.message.api.entity.request.SendSmsRequest;
import com.message.api.service.SendEmailService;
import com.message.api.service.SendSmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceApplicationTests {


    @Autowired
    private SendEmailService sendMailService;

    @Autowired
    private SendSmsService sendSmsService;

    @Test
    public void sendMailTest() {
        Map<String, String> attachments = new HashMap<>(1);
        attachments.put("fileName", "C:\\Users\\future\\Desktop\\URL.txt");
        SendEmailRequest request = new SendEmailRequest("18210063390@163.com", "send email",
                "send email test and attachments", attachments);
        sendMailService.sendMail(request);
        System.out.println("发送成功");
    }

    @Test
    public void sendSmsTest() {
        sendSmsService.sendSms(new SendSmsRequest("18888888888", "test", "send sms test"));
    }


}

package com.message.service.implement;

import com.alibaba.dubbo.config.annotation.Service;
import com.message.api.entity.request.SendEmailRequest;
import com.message.api.entity.response.MessageResponse;
import com.message.api.service.SendEmailService;
import com.message.service.config.properties.EmailProperties;
import com.base.utils.AttachmentSuffixUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Set;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.service.implement
 * @date: Created in 2018/8/7  12:00
 */
@Service(interfaceClass = SendEmailService.class)
public class SendEmailServiceImpl implements SendEmailService {

    private static final Logger logger = LoggerFactory.getLogger(SendEmailServiceImpl.class);

    @Autowired
    private EmailProperties emailProperties;

    @Autowired
    private JavaMailSender sender;

    private static final String PERSONAL = "project";

    /**
     * 发送邮箱
     *
     * @return
     */
    @Override
    public MessageResponse sendMail(SendEmailRequest sendEmailRequest) {
        try {
            MimeMessage mimeMessage = sender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
            //发送者
            message.setFrom(emailProperties.getUsername(), PERSONAL);
            //接受者
            message.setTo(sendEmailRequest.getReceive());
            //标题
            message.setSubject(sendEmailRequest.getSubject());
            //内容
            message.setText(sendEmailRequest.getContent(), false);
            //附件
            if (sendEmailRequest.getAttachments() != null) {
                Set<String> keys = sendEmailRequest.getAttachments().keySet();
                keys.forEach(key -> {
                    try {
                        String path = sendEmailRequest.getAttachments().get(key);
                        key += AttachmentSuffixUtil.getSuffix(path, ".");
                        message.addAttachment(key, new FileSystemResource(new File(path)));
                    } catch (MessagingException e) {
                        logger.error("send mail error:", e);
                    }
                });
            }
            sender.send(mimeMessage);
            return MessageResponse.success();
        } catch (MessagingException e) {
            logger.error("send mail error:", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("send mail error:", e);
        }
        return null;
    }


}

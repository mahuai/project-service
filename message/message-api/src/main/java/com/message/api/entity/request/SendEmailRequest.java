package com.message.api.entity.request;

import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.api.entity.request
 * @date: Created in 2018/8/7  15:12
 */
public class SendEmailRequest  implements Serializable {

    private static final long serialVersionUID = 1L;

    private SendEmailRequest() {
    }

    public SendEmailRequest(String receive, String subject, String content, Map<String, String> attachments) {
        this.receive = receive;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
    }

    private String receive;

    private String subject;

    private String content;

    private Map<String, String> attachments;

    public String getReceive() {
        return receive;

    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, String> attachments) {
        this.attachments = attachments;
    }

}

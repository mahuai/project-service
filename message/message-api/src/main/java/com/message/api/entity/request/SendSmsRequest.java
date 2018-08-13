package com.message.api.entity.request;

import java.io.Serializable;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.api.entity.request
 * @date: Created in 2018/8/7  17:03
 */
public class SendSmsRequest  implements Serializable {

    private static final long serialVersionUID = 1L;

    private SendSmsRequest() {
    }

    public SendSmsRequest(String phone, String subject, String content) {
        this.phone = phone;
        this.subject = subject;
        this.content = content;
    }

    private String phone;

    private String subject;

    private String content;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}

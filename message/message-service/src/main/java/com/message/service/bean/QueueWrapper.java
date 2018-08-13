package com.message.service.bean;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.service.bean
 * @date: Created in 2018/8/7  17:01
 */
public class QueueWrapper  implements Serializable {

    private static final long serialVersionUID = 1L;


    public <T> QueueWrapper createWrapper(T t) {
        QueueWrapper wrapper = new QueueWrapper();
        BeanUtils.copyProperties(t, wrapper);
        return wrapper;
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

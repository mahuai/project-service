package com.message.api.entity.response;

import java.io.Serializable;

/**
 * @author ms
 * @Description: class description
 * @Package com.message.api.entity.response
 * @date: Created in 2018/8/7  11:59
 */
public class MessageResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public MessageResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static MessageResponse success() {
        return new MessageResponse(0, "success");
    }

    public static MessageResponse error() {
        return new MessageResponse(1, "error");
    }
}

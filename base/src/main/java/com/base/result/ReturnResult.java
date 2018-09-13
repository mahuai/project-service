package com.base.result;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author future
 * @Description:
 * @Package com.base.result project-service
 * @date: Created in 2018/7/1310:32
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnResult<T> {

    public ReturnResult() {
    }


    public ReturnResult(Integer resultCode, T data, String resultMessage) {
        Header header = new Header(resultCode, resultMessage);
        this.setHeader(header);
        this.setBody(data);
    }


    public static ReturnResult instantiation() {
        return new ReturnResult();
    }

    /**
     * 消息头
     */
    private Header header;

    /**
     * 消息体
     */
    private T body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ReturnResult{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}

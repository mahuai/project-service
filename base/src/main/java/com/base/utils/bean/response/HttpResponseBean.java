package com.base.utils.bean.response;

import java.util.Map;

/**
 * @author future
 * @Description:
 * @Package com.base.utils.beanproject-service
 * @date: Created in 2018/7/1017:38
 */
public class HttpResponseBean {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public HttpResponseBean(){

    }
    /**
     * 返回报文内容
     */
    private String responseBody;
    /**
     * http响应码
     */
    private int statusCode;

    /**
     * http响应头
     */
    private Map<String,String> headers;

    /**
     * @return the responseBody
     */
    public String getResponseBody() {
        return responseBody;
    }
    /**
     * @param responseBody the responseBody to set
     */
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }
    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    /**
     * @return the headers
     */
    public Map<String, String> getHeaders() {
        return headers;
    }
    /**
     * @param headers the headers to set
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}

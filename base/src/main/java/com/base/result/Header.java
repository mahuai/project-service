package com.base.result;

/**
 * @author future
 * @Description:
 * @Package com.base project-service
 * @date: Created in 2018/7/1310:28
 */
public class Header {

    public Header() {
    }

    public Header(Integer resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    /**
     * 消息结果编码
     */
    private Integer resultCode;

    /**
     * 消息结果
     */
    private String resultMessage;


    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}

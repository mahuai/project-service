package com.resource.api.entity.response;

import java.io.Serializable;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.api.entity.response
 * @date: Created in 2018/9/12  14:23
 */
public class FileResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public FileResponse(Integer chunkSize, String fileName, String contentLength, String contentType, byte[] content) {
        this.chunkSize = chunkSize;
        this.fileName = fileName;
        this.contentLength = contentLength;
        this.contentType = contentType;
        this.content = content;
    }


    private String fileName;

    private String contentType;

    private Integer chunkSize;

    private String contentLength;

    private byte[] content;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Integer chunkSize) {
        this.chunkSize = chunkSize;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}

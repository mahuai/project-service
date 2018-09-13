package com.resource.api.entity.request;

import java.io.Serializable;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.api.entity.request
 * @date: Created in 2018/8/28  11:47
 */
public class UploadRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private UploadRequest() {
    }

    public UploadRequest(String filePath, String fileName, String contentType, Metadata metadata) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.contentType = contentType;
        this.metadata = metadata;
    }

    private String filePath;

    private String fileName;

    private String contentType;

    private Metadata metadata;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public static class Metadata implements Serializable {

        private static final long serialVersionUID = 1L;

        public Metadata(Integer type, String description) {
            this.type = type;
            this.description = description;
        }

        private Integer type;
        private String description;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


}

package com.resource.api.entity.request;

import java.io.Serializable;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.api.entity.request
 * @date: Created in 2018/8/28  11:52
 */
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public QueryRequest() {
    }

    public QueryRequest(Object whereContentType) {
        this.whereContentType = whereContentType;
    }

    public QueryRequest(String objectId) {
        this.objectId = objectId;
    }

    private String objectId;

    private Object whereFilename;

    private Object whereContentType;

    private Object whereMetaData;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Object getWhereFilename() {
        return whereFilename;
    }

    public void setWhereFilename(Object whereFilename) {
        this.whereFilename = whereFilename;
    }

    public Object getWhereContentType() {
        return whereContentType;
    }

    public void setWhereContentType(Object whereContentType) {
        this.whereContentType = whereContentType;
    }

    public Object getWhereMetaData() {
        return whereMetaData;
    }

    public void setWhereMetaData(Object whereMetaData) {
        this.whereMetaData = whereMetaData;
    }
}

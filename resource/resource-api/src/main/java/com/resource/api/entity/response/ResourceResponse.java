package com.resource.api.entity.response;

import java.io.Serializable;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.api.entity.response
 * @date: Created in 2018/8/28  11:49
 */
public class ResourceResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public ResourceResponse(String objectId) {
        this.objectId = objectId;
    }

    private String objectId;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}

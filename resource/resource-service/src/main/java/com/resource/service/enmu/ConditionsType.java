package com.resource.service.enmu;

import org.springframework.data.mongodb.gridfs.GridFsCriteria;

/**
 * @author ms
 * @Description: class description
 * @Package com.resource.service.enmu
 * @date: Created in 2018/9/13  11:44
 */
public enum ConditionsType {

    /**
     * Object id
     */
    WHERE_OBJECT_ID("where_object_id", "_id"),
    /**
     * file name
     */
    WHERE_FILE_NAME("whereFilename", GridFsCriteria.whereFilename()),
    /**
     * content type
     */
    WHERE_CONTENT_TYPE("whereContentType", GridFsCriteria.whereContentType()),
    /**
     * meta data
     */
    WHERE_META_DATA("whereMetaData", GridFsCriteria.whereMetaData());

    ConditionsType(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    private String key;

    private Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

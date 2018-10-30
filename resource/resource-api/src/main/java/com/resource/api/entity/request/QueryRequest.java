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


    private Object condition;

    private Object value;


    public QueryRequest(Object condition, Object value) {

        this.condition = condition;
        this.value = value;
    }

    public Object getCondition() {
        return condition;
    }

    public void setCondition(Object condition) {
        this.condition = condition;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}



package com.ivy.system.enums;

import java.util.Map;

public class DictItemBean {

    public static DictItemBean of(Integer value, String label, Map<String,Object> params) {
        final DictItemBean dictItemBean = new DictItemBean();
        dictItemBean.setValue(value);
        dictItemBean.setLabel(label);
        dictItemBean.setParams(params);
        return dictItemBean;
    }

    private Integer value;

    private String label;

    private Map<String,Object> params;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}

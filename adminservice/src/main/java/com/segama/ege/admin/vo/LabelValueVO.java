package com.segama.ege.admin.vo;

import java.util.Objects;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-04-12 11:16
 */
public class LabelValueVO {
    private String label;
    private Object value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelValueVO that = (LabelValueVO) o;
        return Objects.equals(label, that.label) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value);
    }
}

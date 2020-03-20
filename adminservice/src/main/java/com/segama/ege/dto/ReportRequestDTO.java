package com.segama.ege.dto;
import java.io.Serializable;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @String 2019-12-01 00:13
 */
public class ReportRequestDTO implements Serializable {

    private boolean report_have_exception;

    private Long order_id;

    private String order_string_id;

    private String report_items;

    private static final long serialVersionUID = 1L;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_string_id() {
        return order_string_id;
    }

    public void setOrder_string_id(String order_string_id) {
        this.order_string_id = order_string_id == null ? null : order_string_id.trim();
    }

    public String getReport_items() {
        return report_items;
    }

    public void setReport_items(String report_items) {
        this.report_items = report_items == null ? null : report_items.trim();
    }

    public boolean isReport_have_exception() {
        return report_have_exception;
    }

    public void setReport_have_exception(boolean report_have_exception) {
        this.report_have_exception = report_have_exception;
    }
}

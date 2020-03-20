package com.segama.ege.dto;

public class ContactInfoResponseDTO {
    private String customer_service_wechat_qr_code;
    private String customer_service_phone;
    private String customer_service_email;
    private String description_words;

    public String getCustomer_service_wechat_qr_code() {
        return customer_service_wechat_qr_code;
    }

    public void setCustomer_service_wechat_qr_code(String customer_service_wechat_qr_code) {
        this.customer_service_wechat_qr_code = customer_service_wechat_qr_code;
    }

    public String getCustomer_service_phone() {
        return customer_service_phone;
    }

    public void setCustomer_service_phone(String customer_service_phone) {
        this.customer_service_phone = customer_service_phone;
    }

    public String getCustomer_service_email() {
        return customer_service_email;
    }

    public void setCustomer_service_email(String customer_service_email) {
        this.customer_service_email = customer_service_email;
    }

    public String getDescription_words() {
        return description_words;
    }

    public void setDescription_words(String description_words) {
        this.description_words = description_words;
    }
}

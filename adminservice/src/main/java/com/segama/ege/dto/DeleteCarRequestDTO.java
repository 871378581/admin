package com.segama.ege.dto;

public class DeleteCarRequestDTO {

    private String user_id;

    private Long id = 0L;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.segama.ege.admin.response;

import com.segama.ege.entity.ThOrderManage;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-04-14 23:01
 */
public class ShishouOrder extends ThOrderManage {
    private String channel_name;

    private String owner_account;

    private String create_account;

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getOwner_account() {
        return owner_account;
    }

    public void setOwner_account(String owner_account) {
        this.owner_account = owner_account;
    }

    public String getCreate_account() {
        return create_account;
    }

    public void setCreate_account(String create_account) {
        this.create_account = create_account;
    }
}

package com.segama.ege.dto.wx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 2/5/15
 * Time         : 7:54 PM
 * Description  : js ticket
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JSShareTicket {
    private String ticket;

    public String getTicket() {
        return ticket;
    }
}

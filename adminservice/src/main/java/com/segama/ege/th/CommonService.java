package com.segama.ege.th;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description
 * @date 2020-03-31 22:27
 */
@Component
public class CommonService<R> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<R> selectByCode(Object[] param){
        List<R> query = jdbcTemplate.query("SELECT * FROM ? where id > ?  limit ?,? ", param,
                new BeanPropertyRowMapper<R>());
        return query;
    }
}

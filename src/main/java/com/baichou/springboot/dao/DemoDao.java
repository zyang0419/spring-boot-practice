package com.baichou.springboot.dao;

import com.baichou.springboot.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
/**
 * Created by root on 16-10-20.
 * <p>
 * <p>
 * 使用JdbcTemplate操作数据库.
 * @author root
 */
@Repository
public class DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 通过id获取demo对象.
     * @param id
     * @return
     */
    public Demo getById(long id) {
        String sql = "select * from t_demo where id=?";
        RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
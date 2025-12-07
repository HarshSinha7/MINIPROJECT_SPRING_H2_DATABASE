package com.practice.Repository;

import com.practice.Mapper.SignUpMapper;
import com.practice.beans.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DashboardRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<SignUp> getUser(){
        String sql="SELECT * FROM sign_up";
        return jdbcTemplate.query(sql, new SignUpMapper());
    }
}

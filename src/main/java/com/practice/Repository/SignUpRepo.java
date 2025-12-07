package com.practice.Repository;

import com.practice.Mapper.SignUpMapper;
import com.practice.beans.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

@Repository
public class SignUpRepo {
    @Autowired
    JdbcTemplate jdbc;

    public int saveMessage(SignUp signUp){
        String sql="INSERT INTO sign_up (name,email,password,created_by) VALUES (?,?,?,?)";
        return jdbc.update(sql,signUp.getUsername(),signUp.getEmail(),signUp.getPassword(),signUp.getUsername());

    }
    public String getUsername(String username){
        String sql="SELECT name FROM sign_up WHERE name=?";
        try {
            return jdbc.queryForObject(sql, String.class, username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

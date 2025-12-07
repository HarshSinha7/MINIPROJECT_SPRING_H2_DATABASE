package com.practice.Mapper;


import com.practice.beans.SignUp;
import org.springframework.jdbc.core.RowMapper;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpMapper implements RowMapper<SignUp> {
    public SignUp mapRow(ResultSet rs, int rowNum) throws SQLException{
        SignUp signUp=new SignUp();
        signUp.setUsername(rs.getString("name"));
        signUp.setEmail(rs.getString("email"));
        signUp.setCreated_at(rs.getTimestamp("created_at").toString());
        return signUp;
    }
}

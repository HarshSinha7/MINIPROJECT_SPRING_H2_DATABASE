package com.practice.beans;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Data
public class SignUp extends BaseEntity{

    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 4, max = 10, message = "Username must be 4–10 characters long")
    private String username;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 4, message = "Password must be at least 4 characters long")
    private String password;
}

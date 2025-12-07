package com.practice.Service;
import com.practice.Repository.SignUpRepo;
import com.practice.beans.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Autowired
    SignUpRepo repo;
    public boolean saveMessage(SignUp signUp){
        if(repo.saveMessage(signUp)>=1) return true;
        return false;
    }
    public String getUsername(String userName){
        if(repo.getUsername(userName)==null){
            return "valid";
        }
        return "invalid";
    }
}

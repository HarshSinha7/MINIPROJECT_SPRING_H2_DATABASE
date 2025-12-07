package com.practice.Service;

import com.practice.Repository.DashboardRepo;
import com.practice.beans.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    @Autowired
    DashboardRepo dashboardRepo;
    public List<SignUp> getList(){
        return dashboardRepo.getUser();
    }
}

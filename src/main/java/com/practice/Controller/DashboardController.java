package com.practice.Controller;

import com.practice.Service.DashboardService;
import com.practice.beans.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    DashboardService dashboardService;
    @RequestMapping(value="/dashboard")
    public String dashboardController(Authentication auth, Model model){
        model.addAttribute("username", auth.getName());
        List<SignUp> list= dashboardService.getList();
        model.addAttribute("userList", list);
        return "dashboard.html";
    }
}

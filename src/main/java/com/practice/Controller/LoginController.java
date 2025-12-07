package com.practice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginController(@RequestParam(required = false, value = "error") String error, @RequestParam(required = false, value="logout") String logout, Model model){
        if(error!=null){
            model.addAttribute("data","Something is incorrect!!");
        }
        if(logout!=null){
            model.addAttribute("data","Logout sucessfull");
        }
        return "login.html";
    }
}

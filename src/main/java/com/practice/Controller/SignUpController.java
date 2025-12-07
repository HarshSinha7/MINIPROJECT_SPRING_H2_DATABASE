package com.practice.Controller;

import com.practice.Service.SignUpService;
import com.practice.beans.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {

    @Autowired
    SignUpService service;

    @RequestMapping(value="/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public String signUpController(Model model,@Validated @ModelAttribute("signup") SignUp signUp, Errors error, RedirectAttributes redirectAttributes){
        if(error.hasErrors()){
            return "signup.html";
        }
        if(service.getUsername(signUp.getUsername()).equals("invalid")){
            model.addAttribute("errorMessage", "Username already taken!");
            return "signup.html";
        }
        if(!service.saveMessage(signUp)){
            model.addAttribute("errorMessage","Data is not saved!");
            return "signup.html";
        }
        redirectAttributes.addFlashAttribute("data", "Sign Up sucessfull!");
        return "redirect:/login";
    }
}

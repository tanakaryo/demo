package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserMapperDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserEntity;

@Controller
public class DemoController {
    

    @Autowired
    UserMapperDao dao;

    @RequestMapping("/index")
    public String index(Model form) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model form) {
        return "login";
    }

    @RequestMapping("/login/error")
    public String loginError(Model form) {
        form.addAttribute("error", "kkkk");
        return "login";
    }

    @RequestMapping("/mnglogin")
    public String mnglogin(Model form) {
        return "mnglogin";
    }

    @RequestMapping("/success")
    public String success(Model form) {
        return "success";
    }

    @RequestMapping("/sample")
    public String sample(Model form) {
        return "sample";
    }

    @RequestMapping("/logout")
    public String logout(Model form) {
        return "/usr/logout";
    }
}

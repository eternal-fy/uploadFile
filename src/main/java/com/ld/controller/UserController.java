package com.ld.controller;

import com.ld.pojo.User;
import com.ld.service.UserService;
import com.ld.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers(){
        List<User> users = userService.queryAll();
        System.out.println(users);
        return users;
    }
    @PostMapping("/regis")
    public String register(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User result = userService.queryUser(user.getId());
        if(result==null){
            int i = userService.insertUser(user);
            System.out.println(i+"条数据受到影响");
        }
        return "redirect:welcome.html";
    }

    @PostMapping("/login")
    public String login(String username,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(username+"---------"+password);
        password= Md5.encryptPass(password);
        String repassword=userService.getPassword(username);
        if(password.equals(repassword))
            return "mainPage";
        else
            return "redirect:welcome.html";
    }
}

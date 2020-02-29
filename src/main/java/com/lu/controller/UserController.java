package com.lu.controller;

import com.lu.dao.UserDao;
import com.lu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(){
        String names = "";
        List<User> all = userDao.findAll();
        for (User user : all) {
            names += user.getUsername();
            names += "\n";
        }
        return "welcom " + names;
    }
}

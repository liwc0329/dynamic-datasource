package com.g7go.demo.controller;

import com.g7go.demo.pojo.User;
import com.g7go.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr_Lee
 * @date 2019-10-17 15:12
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/dataInsertUser")
    public String dataInsertUser() {
        User user = new User();
        user.setId(1);
        user.setAge(18);
        user.setName("张三");
        user.setSal(5000);
        userService.dataInsertUser(user);
        return "success";
    }

    @GetMapping("/data1InsertUser")
    public String data1InsertUser() {
        User user = new User();
        user.setId(2);
        user.setAge(19);
        user.setName("李四");
        user.setSal(6000);
        userService.data1InsertUser(user);
        return "success";
    }

    @GetMapping("/data2InsertUser")
    public String data2InsertUser() {
        User user = new User();
        user.setId(3);
        user.setAge(20);
        user.setName("王五");
        user.setSal(7000);
        userService.data2InsertUser(user);
        return "success";
    }

}

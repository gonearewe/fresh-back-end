package com.mactavish.fresh.controller;

import com.mactavish.fresh.result.Result;
import com.mactavish.fresh.pojo.User;
import com.mactavish.fresh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        System.out.println(userService.getByName("admin"));
        if (null == user) {
            System.out.println("req");
            return new Result(400);
        } else {
            System.out.println("OK");
            return new Result(200);
        }
    }
}

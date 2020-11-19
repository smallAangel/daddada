package com.cx.atcrowdfunding.controller;
import com.cx.atcrowdfunding.bean.User;
import com.cx.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cx
 * @create 2020-11-17 10:10
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Object queryAll() {
        List<User> users = userService.queryAll();
        return users;
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/json")
    public Object json() {
        Map map = new HashMap();
        map.put("username", "zhangsan");
        return map;
    }
}

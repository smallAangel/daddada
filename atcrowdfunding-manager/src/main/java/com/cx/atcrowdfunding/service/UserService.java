package com.cx.atcrowdfunding.service;

import com.cx.atcrowdfunding.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author cx
 * @create 2020-11-17 10:11
 */
public interface UserService {
    List<User> queryAll();

    User query4Login(User user);

    List<User> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);
}

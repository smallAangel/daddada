package com.cx.atcrowdfunding.service.impl;
import com.cx.atcrowdfunding.dao.UserDao;
import com.cx.atcrowdfunding.service.UserService;
import com.cx.atcrowdfunding.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author cx
 * @create 2020-11-17 10:13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    public User query4Login(User user) {
        return userDao.query4Login(user);
    }

    public List<User> pageQueryData(Map<String, Object> map) {
        return userDao.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return userDao.pageQueryCount(map);
    }
}

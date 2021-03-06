package com.cx.atcrowdfunding.dao;

import com.cx.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author cx
 * @create 2020-11-17 10:14
 */
public interface UserDao {
    @Select("select * from t_user")
    List<User> queryAll();
    @Select("select * from t_user where loginacct = #{loginacct} and userpswd = #{userpswd}")
    User query4Login(User user);
    List<User> pageQueryData(Map<String, Object> map);
    int pageQueryCount(Map<String, Object> map);
//    void insertUser(User user);
//    @Select("select * from t_user where id = #{id}")
//    User queryById(Integer id);
//
//    void updateUser(User user);
//
//    void deleteUserById(Integer id);
//
//    void deleteUsers(Map<String, Object> map);
//
//    void insertUserRoles(Map<String, Object> map);
//
//    void deleteUserRoles(Map<String, Object> map);
//
//    @Select("select roleid from t_user_role where userid = #{userid}")
//    List<Integer> queryRoleidsByUserid(Integer id);
}

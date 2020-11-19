package com.cx.atcrowdfunding.controller;

import com.cx.atcrowdfunding.bean.AJAXResult;
import com.cx.atcrowdfunding.bean.Page;
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
 * @create 2020-11-17 15:22
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public String index() {
        return "user/index";
    }
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(Integer pageno, Integer pagesize ) {

        AJAXResult result = new AJAXResult();

        try {

            // 分页查询
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", (pageno-1)*pagesize);
            map.put("size", pagesize);
//            map.put("queryText", queryText);
            List<User> users = userService.pageQueryData( map );
            // 当前页码
            // 总的数据条数
            int totalsize = userService.pageQueryCount( map );
            // 最大页码（总页码）
            int totalno = 0;
            if ( totalsize % pagesize == 0 ) {
                totalno = totalsize / pagesize;
            }else {
                totalno = totalsize / pagesize+1;
            }
            // 分页对象
            Page<User> userPage = new Page<User>();
            userPage.setDatas(users);
            userPage.setTotalno(totalno);
            userPage.setTotalsize(totalsize);
            userPage.setPageno(pageno);
            result.setData(userPage);
            System.out.println(userPage.toString());
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;

    }
}

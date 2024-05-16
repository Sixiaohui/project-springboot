package com.codeying.controller;

import com.codeying.component.ApiResult;
import com.codeying.mapper.SqlMapper;
import com.codeying.mapper.SqlMapper.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.ui.Model;
import com.codeying.component.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codeying.entity.*;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * 登陆、注册、登出
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private SqlMapper sqlMapper;

    @RequestMapping("/")
    public String index(){
        LoginUser user = getCurrentUser();
        if(user==null)return "login";
        return "hello";
    }
    /**
    * 欢迎页
    */
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    /**
    * 登录页
    */
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    public String login(String captcha, String username, String password, String usertype) throws Exception {
        //登录开始
        req.setCharacterEncoding("utf-8");
        //登陆的用户
        LoginUser loginUser;
        if (usertype.equals("admin")) {
            QueryWrapper<Admin> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            wrapper.eq("password", password);
            loginUser = adminService.getOne(wrapper);
            if (loginUser != null) {
                req.getSession().setAttribute("user", loginUser);
                req.getSession().setAttribute("role", "admin");
                return "hello" ;
            }
        }
        if (usertype.equals("ganbu")) {
            QueryWrapper<Ganbu> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            wrapper.eq("password", password);
            loginUser = ganbuService.getOne(wrapper);
            if (loginUser != null) {
                req.getSession().setAttribute("user", loginUser);
                req.getSession().setAttribute("role", "ganbu");
                return "hello" ;
            }
        }
        if (usertype.equals("user")) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            wrapper.eq("password", password);
            loginUser = userService.getOne(wrapper);
            if (loginUser != null) {
                req.getSession().setAttribute("user", loginUser);
                req.getSession().setAttribute("role", "user");
                return "hello" ;
            }
        }
        //登陆失败，就重新登陆
        req.setAttribute("message", "账号密码有误，登陆失败");
        return "login" ;
    }

    /**
    * 注册
    */
    @GetMapping("register")
    public String register(){
        return "register";
    }
    @PostMapping("register")
    public String register(String username, String password, String usertype) throws Exception {
        req.setCharacterEncoding("utf-8");
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            req.setAttribute("message", "账号密码不可为空！");
            return "register" ;
        }
        if (usertype.equals("admin")) {
            QueryWrapper<Admin> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            Admin temp = adminService.getOne(wrapper);
            if (temp != null) {
                req.setAttribute("message", "账号已存在！");
                return "register" ;
            }
            Admin admin = new Admin ();
            admin.setUsername(username);
            admin.setPassword(password);
                                                            String id = ""; //主键
                                                                admin .setId (CommonUtils.newId());
                                                                                                                                            String name = ""; //姓名
                                                                                                        String tele = ""; //电话
                                                                                adminService.save(admin);
            req.setAttribute("message", "注册成功，请登陆");
            return "login" ;
        }
        if (usertype.equals("ganbu")) {
            QueryWrapper<Ganbu> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            Ganbu temp = ganbuService.getOne(wrapper);
            if (temp != null) {
                req.setAttribute("message", "账号已存在！");
                return "register" ;
            }
            Ganbu ganbu = new Ganbu ();
            ganbu.setUsername(username);
            ganbu.setPassword(password);
                                                            String id = ""; //主键
                                                                ganbu .setId (CommonUtils.newId());
                                                                                                                                            String name = ""; //姓名
                                                                                                        String gender = ""; //性别
                                                                                                        String tele = ""; //电话
                                                                                                        Integer age = 0; //年龄
                                                                                                        String zhic = ""; //职称
                                                                                                        String describtion = ""; //个人简介
                                                                                ganbuService.save(ganbu);
            req.setAttribute("message", "注册成功，请登陆");
            return "login" ;
        }
        if (usertype.equals("user")) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            User temp = userService.getOne(wrapper);
            if (temp != null) {
                req.setAttribute("message", "账号已存在！");
                return "register" ;
            }
            User user = new User ();
            user.setUsername(username);
            user.setPassword(password);
                                                            String id = ""; //主键
                                                                user .setId (CommonUtils.newId());
                                                                                                                                            String name = ""; //名称
                                                                                                        String gender = ""; //性别
                                                                                                        String tele = ""; //电话
                                                                                                        Integer age = 0; //年龄
                                                                                                        String place = ""; //所在地址
                                                                                                        String wanggeid = ""; //所属网格
                                                                                                        String idnum = ""; //身份证
                                                                                                        String huji = ""; //户籍信息
                                                                                userService.save(user);
            req.setAttribute("message", "注册成功，请登陆");
            return "login" ;
        }
        //注册失败
        req.setAttribute("message", "请选择角色类型");
        return "register" ;
    }


    //登出
    @RequestMapping("logout")
    public String logout() {
        // 让session失效。
        req.getSession().removeAttribute("user");
        return "login";
    }


    /**
     * 自定义查询
     */
    @GetMapping("q")
    public String query(Model model,String t){//业务类型
        String sql = "select '请访问正确的地址！' as 查询结果", title = "查询";
        List< LinkedHashMap< String, String>> res = null;
        switch (t) {
            case "1": {
                title = "测试查询";
                sql = "select '测试' as test";
                break;
            }

        }
        //查询
        res = sqlMapper.getQueryMap(sql);
        model.addAttribute("title", title);//查询标题
        model.addAttribute("t", t);//查询类型
        model.addAttribute("res", res);//结果集
        return "/pages/query";
    }

	//echarts数据
    @PostMapping("hello")
    @ResponseBody
    public ApiResult< List< Echart>> helloData() {
        //数据
        List< Echart> l = new ArrayList<>();
        //图表1..
        Echart echart = new Echart();
        echart.setName("XXX的统计");
        //echart.setDtos(sqlMapper.exec("select s.numb as name,avg(ss.score) as value from....."));
        //l.add(echart.init()); //TODO　添加echarts后记得添加到list
        return successData(l);
    }

}


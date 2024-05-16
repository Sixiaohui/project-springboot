package com.codeying.controller;

import com.codeying.component.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.codeying.entity.LoginUser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.codeying.service.*;
/**
 * 项目Controller通用父类
 */
public class BaseController {

    @Autowired
    protected AdminService adminService;
    @Autowired
    protected GanbuService ganbuService;
    @Autowired
    protected UserService userService;
    @Autowired
    protected WanggeService wanggeService;
    @Autowired
    protected ZichanService zichanService;
    @Autowired
    protected ShiyongService shiyongService;
    @Autowired
    protected ZjsyService zjsyService;
    @Autowired
    protected CwsrService cwsrService;
    @Autowired
    protected CunwuService cunwuService;
    @Autowired
    protected ProjService projService;
    @Autowired
    protected ShouruService shouruService;
    @Autowired
    protected TousuService tousuService;
    @Autowired
    protected NoticeService noticeService;
    @Autowired
    protected UserCommentService userCommentService;
    @Autowired
    protected HttpServletRequest req;

    @Autowired
    protected HttpServletResponse resp;

    @Autowired
    protected HttpSession session;

    /**
     * 获取Session中的值
     * @param key key
     * @return value
     */
    protected Object getSessionValue(String key) {
        return this.session.getAttribute(key);
    }

    /**
     * 设置Session中的值
     * @param key key
     * @param value value
     */
    protected void setSessionValue(String key, Object value) {
        this.session.setAttribute(key, value);
    }

    /**
     * 移除Session中的值
     * @param key value
     */
    protected void removeSessionValue(String key) {
        this.session.removeAttribute(key);
    }

    protected < T> ApiResult< T> success() {
        return ApiResult.success();
    }

    protected < T> ApiResult< T> successMsg(String message) {
        return ApiResult.successMsg(message);
    }

    protected < T> ApiResult< T> successData(T data) {
        return ApiResult.successData(data);
    }

    protected < T> ApiResult< T> successMsgAndData(String message, T data) {
        return ApiResult.successMsgAndData(message, data);
    }

    protected < T> ApiResult< T> fail() {
        return ApiResult.fail();
    }

    protected < T> ApiResult< T> fail(String message) {
        return ApiResult.fail(message);
    }
    protected < T> ApiResult< T> fail(String message,T data) {
        return ApiResult.fail(message,data);
    }

    /**
     转发
     */
    protected  ApiResult< String> redirect(String url,String message){
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(301);
        apiResult.setMessage(message);
        apiResult.setSuccess(false);
        apiResult.setData(url);
        return apiResult;
    }
    protected  ApiResult< String> redirect(String url){
        return redirect(url,"");
    }

    //获取当前登陆用户
    protected LoginUser getCurrentUser(){
        return (LoginUser) getSessionValue("user");
    }
    //获取当前登陆用户的角色
    protected String role(){
        return (String) getSessionValue("role");
    }

}


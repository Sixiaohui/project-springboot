package com.codeying.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;

import java.io.Serializable;
/**
* 村干部实体类
*/
@TableName("tb_ganbu")
public class Ganbu extends LoginUser implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 用户名
    */
    @TableField("username")
    
    private String username;
    
    /**
     * 密码
    */
    @TableField("password")
    
    private String password;
    
    /**
     * 姓名
    */
    @TableField("name")
    
    private String name;
    
    /**
     * 性别
    */
    @TableField("gender")
    
    private String gender;
    
    /**
     * 电话
    */
    @TableField("tele")
    
    private String tele;
    
    /**
     * 年龄
    */
    @TableField("age")
    
    private Integer age;
    
    /**
     * 职称
    */
    @TableField("zhic")
    
    private String zhic;
    
    /**
     * 个人简介
    */
    @TableField("describtion")
    
    private String describtion;
    


    public String getId () {
        return id;
    }

    public void setId (String id ) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password ) {
        this.password = password;
    }

    public String getName () {
        return name;
    }

    public void setName (String name ) {
        this.name = name;
    }

    public String getGender () {
        return gender;
    }

    public void setGender (String gender ) {
        this.gender = gender;
    }

    public String getTele () {
        return tele;
    }

    public void setTele (String tele ) {
        this.tele = tele;
    }

    public Integer getAge () {
        return age;
    }

    public void setAge (Integer age ) {
        this.age = age;
    }

    public String getZhic () {
        return zhic;
    }

    public void setZhic (String zhic ) {
        this.zhic = zhic;
    }

    public String getDescribtion () {
        return describtion;
    }

    public void setDescribtion (String describtion ) {
        this.describtion = describtion;
    }


    /**
     * 角色
     */
    @TableField(exist = false)
    private String role = "ganbu";
    @TableField(exist = false)
    private String rolech = "村干部";

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getRolech() {
        return rolech;
    }
    public void setRolech(String rolech) {
        this.rolech = rolech;
    }


}


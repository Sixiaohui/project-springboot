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
* 村民实体类
*/
@TableName("tb_user")
public class User extends LoginUser implements Serializable{

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
     * 名称
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
     * 所在地址
    */
    @TableField("place")
    
    private String place;
    
    /**
     * 所属网格
    */
    @TableField("wanggeid")
    
    private String wanggeid;
    
    @TableField(exist = false)
    private Wangge wanggeidFrn;
    /**
     * 身份证
    */
    @TableField("idnum")
    
    private String idnum;
    
    /**
     * 户籍信息
    */
    @TableField("huji")
    
    private String huji;
    


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

    public String getPlace () {
        return place;
    }

    public void setPlace (String place ) {
        this.place = place;
    }

    public String getWanggeid () {
        return wanggeid;
    }

    public void setWanggeid (String wanggeid ) {
        this.wanggeid = wanggeid;
    }

    public Wangge getWanggeidFrn(){
        return  wanggeidFrn;
    }

    public void setWanggeidFrn (Wangge v){
        this.wanggeidFrn = v;
    }
    public String getIdnum () {
        return idnum;
    }

    public void setIdnum (String idnum ) {
        this.idnum = idnum;
    }

    public String getHuji () {
        return huji;
    }

    public void setHuji (String huji ) {
        this.huji = huji;
    }


    /**
     * 角色
     */
    @TableField(exist = false)
    private String role = "user";
    @TableField(exist = false)
    private String rolech = "村民";

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


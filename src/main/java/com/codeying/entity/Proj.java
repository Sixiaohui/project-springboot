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
* 村务项目实体类
*/
@TableName("tb_proj")
public class Proj  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 申报村民
    */
    @TableField("cunid")
    
    private String cunid;
    
    @TableField(exist = false)
    private User cunidFrn;
    /**
     * 项目名
    */
    @TableField("name")
    
    private String name;
    
    /**
     * 项目立项
    */
    @TableField("lixiang")
    
    private String lixiang;
    
    /**
     * 项目进展
    */
    @TableField("jinzhan")
    
    private String jinzhan;
    
    /**
     * 项目备注
    */
    @TableField("remark")
    
    private String remark;
    
    /**
     * 项目经费
    */
    @TableField("jingfei")
    
    private Double jingfei;
    
    /**
     * 审核状态
    */
    @TableField("status")
    
    private String status;
    
    /**
     * 开始时间
    */
    @TableField("kais")
    
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date kais;
    
    /**
     * 结束时间
    */
    @TableField("jies")
    
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date jies;
    


    public String getId () {
        return id;
    }

    public void setId (String id ) {
        this.id = id;
    }

    public String getCunid () {
        return cunid;
    }

    public void setCunid (String cunid ) {
        this.cunid = cunid;
    }

    public User getCunidFrn(){
        return  cunidFrn;
    }

    public void setCunidFrn (User v){
        this.cunidFrn = v;
    }
    public String getName () {
        return name;
    }

    public void setName (String name ) {
        this.name = name;
    }

    public String getLixiang () {
        return lixiang;
    }

    public void setLixiang (String lixiang ) {
        this.lixiang = lixiang;
    }

    public String getJinzhan () {
        return jinzhan;
    }

    public void setJinzhan (String jinzhan ) {
        this.jinzhan = jinzhan;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark ) {
        this.remark = remark;
    }

    public Double getJingfei () {
        return jingfei;
    }

    public void setJingfei (Double jingfei ) {
        this.jingfei = jingfei;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status ) {
        this.status = status;
    }

    public Date getKais () {
        return kais;
    }

    public void setKais (Date kais ) {
        this.kais = kais;
    }

    public Date getJies () {
        return jies;
    }

    public void setJies (Date jies ) {
        this.jies = jies;
    }




}


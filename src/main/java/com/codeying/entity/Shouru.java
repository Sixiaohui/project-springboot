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
* 经济收入实体类
*/
@TableName("tb_shouru")
public class Shouru  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 村民
    */
    @TableField("cunmid")
    
    private String cunmid;
    
    @TableField(exist = false)
    private User cunmidFrn;
    /**
     * 年份
    */
    @TableField("year")
    
    private String year;
    
    /**
     * 收入
    */
    @TableField("shouru")
    
    private Double shouru;
    
    /**
     * 备注
    */
    @TableField("remark")
    
    private String remark;
    


    public String getId () {
        return id;
    }

    public void setId (String id ) {
        this.id = id;
    }

    public String getCunmid () {
        return cunmid;
    }

    public void setCunmid (String cunmid ) {
        this.cunmid = cunmid;
    }

    public User getCunmidFrn(){
        return  cunmidFrn;
    }

    public void setCunmidFrn (User v){
        this.cunmidFrn = v;
    }
    public String getYear () {
        return year;
    }

    public void setYear (String year ) {
        this.year = year;
    }

    public Double getShouru () {
        return shouru;
    }

    public void setShouru (Double shouru ) {
        this.shouru = shouru;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark ) {
        this.remark = remark;
    }




}


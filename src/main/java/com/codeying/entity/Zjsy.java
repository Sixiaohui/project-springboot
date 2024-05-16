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
* 资金使用实体类
*/
@TableName("tb_zjsy")
public class Zjsy  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 支出用途
    */
    @TableField("yongtu")
    
    private String yongtu;
    
    /**
     * 支出类型
    */
    @TableField("type")
    
    private String type;
    
    /**
     * 支出金额
    */
    @TableField("price")
    
    private Double price;
    
    /**
     * 支出时间
    */
    @TableField("shijian")
    
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date shijian;
    
    /**
     * 使用明细
    */
    @TableField("mingxi")
    
    private String mingxi;
    
    /**
     * 负责人
    */
    @TableField("name")
    
    private String name;
    
    @TableField(exist = false)
    private Ganbu nameFrn;
    /**
     * 附件
    */
    @TableField("files")
    
    private String files;
    


    public String getId () {
        return id;
    }

    public void setId (String id ) {
        this.id = id;
    }

    public String getYongtu () {
        return yongtu;
    }

    public void setYongtu (String yongtu ) {
        this.yongtu = yongtu;
    }

    public String getType () {
        return type;
    }

    public void setType (String type ) {
        this.type = type;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price ) {
        this.price = price;
    }

    public Date getShijian () {
        return shijian;
    }

    public void setShijian (Date shijian ) {
        this.shijian = shijian;
    }

    public String getMingxi () {
        return mingxi;
    }

    public void setMingxi (String mingxi ) {
        this.mingxi = mingxi;
    }

    public String getName () {
        return name;
    }

    public void setName (String name ) {
        this.name = name;
    }

    public Ganbu getNameFrn(){
        return  nameFrn;
    }

    public void setNameFrn (Ganbu v){
        this.nameFrn = v;
    }
    public String getFiles () {
        return files;
    }

    public void setFiles (String files ) {
        this.files = files;
    }




}


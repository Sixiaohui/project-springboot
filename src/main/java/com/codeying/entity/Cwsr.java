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
* 财务收入实体类
*/
@TableName("tb_cwsr")
public class Cwsr  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 收入标题
    */
    @TableField("title")
    
    private String title;
    
    /**
     * 收入金额
    */
    @TableField("price")
    
    private Double price;
    
    /**
     * 收入说明
    */
    @TableField("describtion")
    
    private String describtion;
    
    /**
     * 附件
    */
    @TableField("files")
    
    private String files;
    
    /**
     * 收入时间
    */
    @TableField("createtime")
    
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;
    


    public String getId () {
        return id;
    }

    public void setId (String id ) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title ) {
        this.title = title;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price ) {
        this.price = price;
    }

    public String getDescribtion () {
        return describtion;
    }

    public void setDescribtion (String describtion ) {
        this.describtion = describtion;
    }

    public String getFiles () {
        return files;
    }

    public void setFiles (String files ) {
        this.files = files;
    }

    public Date getCreatetime () {
        return createtime;
    }

    public void setCreatetime (Date createtime ) {
        this.createtime = createtime;
    }




}


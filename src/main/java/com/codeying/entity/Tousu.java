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
* 投诉建议实体类
*/
@TableName("tb_tousu")
public class Tousu  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 投诉人
    */
    @TableField("useird")
    
    private String useird;
    
    @TableField(exist = false)
    private User useirdFrn;
    /**
     * 投诉内容
    */
    @TableField("jianjie")
    
    private String jianjie;
    
    /**
     * 投诉时间
    */
    @TableField("createtime")
    
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;
    
    /**
     * 回复
    */
    @TableField("huifu")
    
    private String huifu;
    


    public String getId () {
        return id;
    }

    public void setId (String id ) {
        this.id = id;
    }

    public String getUseird () {
        return useird;
    }

    public void setUseird (String useird ) {
        this.useird = useird;
    }

    public User getUseirdFrn(){
        return  useirdFrn;
    }

    public void setUseirdFrn (User v){
        this.useirdFrn = v;
    }
    public String getJianjie () {
        return jianjie;
    }

    public void setJianjie (String jianjie ) {
        this.jianjie = jianjie;
    }

    public Date getCreatetime () {
        return createtime;
    }

    public void setCreatetime (Date createtime ) {
        this.createtime = createtime;
    }

    public String getHuifu () {
        return huifu;
    }

    public void setHuifu (String huifu ) {
        this.huifu = huifu;
    }




}


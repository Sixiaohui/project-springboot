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
* 村务信息实体类
*/
@TableName("tb_cunwu")
public class Cunwu  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 村务信息名
    */
    @TableField("name")
    
    private String name;
    
    /**
     * 分类
    */
    @TableField("type")
    
    private String type;
    
    /**
     * 村级文件
    */
    @TableField("wenj")
    
    private String wenj;
    
    /**
     * 会议纪要
    */
    @TableField("huiyi")
    
    private String huiyi;
    
    /**
     * 决策文件
    */
    @TableField("juece")
    
    private String juece;
    


    public String getId () {
        return id;
    }

    public void setId (String id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name ) {
        this.name = name;
    }

    public String getType () {
        return type;
    }

    public void setType (String type ) {
        this.type = type;
    }

    public String getWenj () {
        return wenj;
    }

    public void setWenj (String wenj ) {
        this.wenj = wenj;
    }

    public String getHuiyi () {
        return huiyi;
    }

    public void setHuiyi (String huiyi ) {
        this.huiyi = huiyi;
    }

    public String getJuece () {
        return juece;
    }

    public void setJuece (String juece ) {
        this.juece = juece;
    }




}


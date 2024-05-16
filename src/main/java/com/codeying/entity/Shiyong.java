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
* 村土地使用实体类
*/
@TableName("tb_shiyong")
public class Shiyong  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 所属网格
    */
    @TableField("wgid")
    
    private String wgid;
    
    @TableField(exist = false)
    private Wangge wgidFrn;
    /**
     * 使用土地位置
    */
    @TableField("place")
    
    private String place;
    
    /**
     * 使用原因
    */
    @TableField("reason")
    
    private String reason;
    
    /**
     * 使用类型
    */
    @TableField("type")
    
    private String type;
    
    /**
     * 创建时间
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

    public String getWgid () {
        return wgid;
    }

    public void setWgid (String wgid ) {
        this.wgid = wgid;
    }

    public Wangge getWgidFrn(){
        return  wgidFrn;
    }

    public void setWgidFrn (Wangge v){
        this.wgidFrn = v;
    }
    public String getPlace () {
        return place;
    }

    public void setPlace (String place ) {
        this.place = place;
    }

    public String getReason () {
        return reason;
    }

    public void setReason (String reason ) {
        this.reason = reason;
    }

    public String getType () {
        return type;
    }

    public void setType (String type ) {
        this.type = type;
    }

    public Date getCreatetime () {
        return createtime;
    }

    public void setCreatetime (Date createtime ) {
        this.createtime = createtime;
    }




}


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
* 公告实体类
*/
@TableName("tb_notice")
public class Notice  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 标题
    */
    @TableField("title")
    
    private String title;
    
    /**
     * 类型
    */
    @TableField("type")
    
    private String type;
    
    /**
     * 内容
    */
    @TableField("content")
    
    private String content;
    
    /**
     * 发布时间
    */
    @TableField("createtime")
    
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;
    
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

    public String getTitle () {
        return title;
    }

    public void setTitle (String title ) {
        this.title = title;
    }

    public String getType () {
        return type;
    }

    public void setType (String type ) {
        this.type = type;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content ) {
        this.content = content;
    }

    public Date getCreatetime () {
        return createtime;
    }

    public void setCreatetime (Date createtime ) {
        this.createtime = createtime;
    }

    public String getFiles () {
        return files;
    }

    public void setFiles (String files ) {
        this.files = files;
    }




}


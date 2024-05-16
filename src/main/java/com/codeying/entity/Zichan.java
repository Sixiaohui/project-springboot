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
* 村资产信息实体类
*/
@TableName("tb_zichan")
public class Zichan  implements Serializable{

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
     * 村干部
    */
    @TableField("ganbuid")
    
    private String ganbuid;
    
    @TableField(exist = false)
    private Ganbu ganbuidFrn;
    /**
     * 资产名
    */
    @TableField("name")
    
    private String name;
    
    /**
     * 资产编号
    */
    @TableField("numb")
    
    private String numb;
    
    /**
     * 价值
    */
    @TableField("jiazhi")
    
    private Double jiazhi;
    
    /**
     * 数量
    */
    @TableField("count")
    
    private String count;
    
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
    public String getGanbuid () {
        return ganbuid;
    }

    public void setGanbuid (String ganbuid ) {
        this.ganbuid = ganbuid;
    }

    public Ganbu getGanbuidFrn(){
        return  ganbuidFrn;
    }

    public void setGanbuidFrn (Ganbu v){
        this.ganbuidFrn = v;
    }
    public String getName () {
        return name;
    }

    public void setName (String name ) {
        this.name = name;
    }

    public String getNumb () {
        return numb;
    }

    public void setNumb (String numb ) {
        this.numb = numb;
    }

    public Double getJiazhi () {
        return jiazhi;
    }

    public void setJiazhi (Double jiazhi ) {
        this.jiazhi = jiazhi;
    }

    public String getCount () {
        return count;
    }

    public void setCount (String count ) {
        this.count = count;
    }

    public Date getCreatetime () {
        return createtime;
    }

    public void setCreatetime (Date createtime ) {
        this.createtime = createtime;
    }




}


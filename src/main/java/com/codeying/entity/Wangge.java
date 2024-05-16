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
* 网格实体类
*/
@TableName("tb_wangge")
public class Wangge  implements Serializable{

    /**
     * 主键
    */
    @TableId
    private String id;
    
    /**
     * 网格名
    */
    @TableField("name")
    
    private String name;
    
    /**
     * 网格编号
    */
    @TableField("numb")
    
    private String numb;
    
    /**
     * 所属区域
    */
    @TableField("quyu")
    
    private String quyu;
    
    /**
     * 负责人
    */
    @TableField("fuzeid")
    
    private String fuzeid;
    
    @TableField(exist = false)
    private Ganbu fuzeidFrn;
    /**
     * 土地利用率
    */
    @TableField("liyong")
    
    private Double liyong;
    


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

    public String getNumb () {
        return numb;
    }

    public void setNumb (String numb ) {
        this.numb = numb;
    }

    public String getQuyu () {
        return quyu;
    }

    public void setQuyu (String quyu ) {
        this.quyu = quyu;
    }

    public String getFuzeid () {
        return fuzeid;
    }

    public void setFuzeid (String fuzeid ) {
        this.fuzeid = fuzeid;
    }

    public Ganbu getFuzeidFrn(){
        return  fuzeidFrn;
    }

    public void setFuzeidFrn (Ganbu v){
        this.fuzeidFrn = v;
    }
    public Double getLiyong () {
        return liyong;
    }

    public void setLiyong (Double liyong ) {
        this.liyong = liyong;
    }




}


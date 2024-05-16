package com.codeying.controller;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codeying.component.*;
import com.codeying.component.utils.*;
import com.codeying.entity.*;
import com.codeying.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.InputStream;
import java.util.*;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import javax.servlet.ServletOutputStream;
/**
 * 村干部控制器
 * 关于村干部的增删改查操作都在这
 */
@Controller
@RequestMapping("ganbu")
public class GanbuController extends BaseController {

    //村干部列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Ganbu> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的村干部
        List<Ganbu> ganbuList = pageInfo.getRecords();

                                    //定义需要统计的字段
                double sumage = 0;
                    
        //将数据放入request
                                            StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Ganbu stAv : ganbuList){
            if(stAv.getAge ()!=null)
            sumage += stAv.getAge ();
        }

        if( ganbuList .size() > 0){
            statisticInfo.append("年龄平均：").append(String.format("%.2f",sumage / ganbuList .size())).append("; ");
        }
        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("ganbuList",ganbuList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/ganbu-list";
    }

    private IPage<Ganbu> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Ganbu> paramMap = new QueryWrapper<>();
                            String username = req.getParameter("username");
            if(username !=null && !username .equals("")){
                            paramMap.like("username","%"+username+"%");
                    }
                                        String name = req.getParameter("name");
            if(name !=null && !name .equals("")){
                            paramMap.like("name","%"+name+"%");
                    }
                                    String gender = req.getParameter("gender");
            if(gender !=null && !gender .equals("")){
                             paramMap.eq("gender",gender);
                    }
                            
        String orderByStr = "id desc";//默认根据id降序排序
        if (orderby != null && orderby.length>0 ) {//如果前端传来了需要排序的字段，那么根据前端字段排序
            orderByStr = Arrays.toString(orderby);
            //前端传来的排序字段都会有","开头，去掉第一个逗号
            orderByStr = orderByStr.substring(1,orderByStr.length()-1);
        }
        //默认按照id排序
        paramMap.last("order by " + orderByStr);
        //开始分页
        IPage<Ganbu> pageInfo = new Page<Ganbu>().setCurrent(current).setSize(size);
        pageInfo = ganbuService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //村干部编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Ganbu entity = ganbuService.getById(id);
                                                                                                                                                                                                    if(entity==null){
            entity = new Ganbu();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/ganbu-edit";
    }

    //村干部详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Ganbu entity = ganbuService.getById(id);
                                            model.addAttribute("item", entity);
        return "/pages/ganbu-detail";
    }

    //村干部保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Ganbu entityTemp ) {
                String id = entityTemp.getId(); //主键
                    String username = entityTemp.getUsername(); //用户名
                    String password = entityTemp.getPassword(); //密码
                    String name = entityTemp.getName(); //姓名
                    String gender = entityTemp.getGender(); //性别
                    String tele = entityTemp.getTele(); //电话
                    Integer age = entityTemp.getAge();//年龄
                    String zhic = entityTemp.getZhic(); //职称
                    String describtion = entityTemp.getDescribtion(); //个人简介
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                                                                                                                                                                        //唯一字段，则在此校验
                    QueryWrapper<Ganbu> wrapperusername = new QueryWrapper();
                    wrapperusername.eq("username",entityTemp.getUsername());
                    if( ganbuService.list(wrapperusername).size() > 0){
                        return fail("用户名 已存在！");
                    }
                                                                                            //唯一字段，则在此校验
                    QueryWrapper<Ganbu> wrappername = new QueryWrapper();
                    wrappername.eq("name",entityTemp.getName());
                    if( ganbuService.list(wrappername).size() > 0){
                        return fail("姓名 已存在！");
                    }
                                                                                                                                                                                    //=========添加之前
    
            //=========添加之前
            res = ganbuService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = ganbuService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //村干部删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Ganbu delTemp = ganbuService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = ganbuService.removeById(id);
        return res ? success() : fail();
    }


}


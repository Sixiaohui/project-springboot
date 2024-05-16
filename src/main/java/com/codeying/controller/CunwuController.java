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
 * 村务信息控制器
 * 关于村务信息的增删改查操作都在这
 */
@Controller
@RequestMapping("cunwu")
public class CunwuController extends BaseController {

    //村务信息列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Cunwu> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的村务信息
        List<Cunwu> cunwuList = pageInfo.getRecords();

                                
        //将数据放入request
                                StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Cunwu stAv : cunwuList){
        }

        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("cunwuList",cunwuList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/cunwu-list";
    }

    private IPage<Cunwu> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Cunwu> paramMap = new QueryWrapper<>();
                            String name = req.getParameter("name");
            if(name !=null && !name .equals("")){
                            paramMap.like("name","%"+name+"%");
                    }
                                    String type = req.getParameter("type");
            if(type !=null && !type .equals("")){
                            paramMap.like("type","%"+type+"%");
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
        IPage<Cunwu> pageInfo = new Page<Cunwu>().setCurrent(current).setSize(size);
        pageInfo = cunwuService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //村务信息编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Cunwu entity = cunwuService.getById(id);
                                                                                                                                        if(entity==null){
            entity = new Cunwu();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/cunwu-edit";
    }

    //村务信息详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Cunwu entity = cunwuService.getById(id);
                                model.addAttribute("item", entity);
        return "/pages/cunwu-detail";
    }

    //村务信息保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Cunwu entityTemp ,MultipartFile wenjFile ,MultipartFile jueceFile ) {
        //上传村级文件到本地。
        if(wenjFile !=null && wenjFile.getSize() > 0){
            entityTemp.setWenj(CommonUtils.upload(wenjFile));
        }
        //上传决策文件到本地。
        if(jueceFile !=null && jueceFile.getSize() > 0){
            entityTemp.setJuece(CommonUtils.upload(jueceFile));
        }
                String id = entityTemp.getId(); //主键
                    String name = entityTemp.getName(); //村务信息名
                    String type = entityTemp.getType(); //分类
                    String wenj = entityTemp.getWenj(); //村级文件
                    String huiyi = entityTemp.getHuiyi(); //会议纪要
                    String juece = entityTemp.getJuece(); //决策文件
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                                                                                                                                                                                                        //=========添加之前
    
            //=========添加之前
            res = cunwuService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = cunwuService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //村务信息删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Cunwu delTemp = cunwuService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = cunwuService.removeById(id);
        return res ? success() : fail();
    }


}


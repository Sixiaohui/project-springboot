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
 * 评论控制器
 * 关于评论的增删改查操作都在这
 */
@Controller
@RequestMapping("userComment")
public class UserCommentController extends BaseController {

    //评论列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<UserComment> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的评论
        List<UserComment> userCommentList = pageInfo.getRecords();

                                            
        //将数据放入request
                                            StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(UserComment stAv : userCommentList){
        }

        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("userCommentList",userCommentList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/userComment-list";
    }

    private IPage<UserComment> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<UserComment> paramMap = new QueryWrapper<>();
                                String username = req.getParameter("username");
            if(username !=null && !username .equals("")){
                            paramMap.like("username","%"+username+"%");
                    }
                                    String rolech = req.getParameter("rolech");
            if(rolech !=null && !rolech .equals("")){
                            paramMap.like("rolech","%"+rolech+"%");
                    }
                                    String content = req.getParameter("content");
            if(content !=null && !content .equals("")){
                            paramMap.like("content","%"+content+"%");
                    }
                                    if(req.getParameter("createtimeL")!=null && !req.getParameter("createtimeL").equals("")){
                Date createtimeL = DateUtil.strToDate(req.getParameter("createtimeL"));
                paramMap.ge("createtime",createtimeL);
            }
            if(req.getParameter("createtimeR")!=null && !req.getParameter("createtimeR").equals("")){
                Date createtimeR = DateUtil.strToDate(req.getParameter("createtimeR"));
                paramMap.le("createtime",createtimeR);
            }
                                            String status = req.getParameter("status");
            if(status !=null && !status .equals("")){
                             paramMap.eq("status",status);
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
        IPage<UserComment> pageInfo = new Page<UserComment>().setCurrent(current).setSize(size);
        pageInfo = userCommentService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //评论编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        UserComment entity = userCommentService.getById(id);
                                                                                                                                                                                                    if(entity==null){
            entity = new UserComment();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/userComment-edit";
    }

    //评论详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        UserComment entity = userCommentService.getById(id);
                                            model.addAttribute("item", entity);
        return "/pages/userComment-detail";
    }

    //评论保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(UserComment entityTemp ) {
                String id = entityTemp.getId(); //主键
                    String userid = entityTemp.getUserid(); //用户编号
                    String username = entityTemp.getUsername(); //用户名
                    String rolech = entityTemp.getRolech(); //用户角色
                    String content = entityTemp.getContent(); //内容
                    Date createtime = entityTemp.getCreatetime(); //发布时间
                    String ctid = entityTemp.getCtid(); //内容编号
                    String type = entityTemp.getType(); //内容类型
                    String status = entityTemp.getStatus(); //状态
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                createtime = new Date();
                    entityTemp.setCreatetime (createtime);
                                                                                                                                                                                                                                                                                                                                                                                                    //=========添加之前
    
            //=========添加之前
            res = userCommentService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = userCommentService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //评论删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        UserComment delTemp = userCommentService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = userCommentService.removeById(id);
        return res ? success() : fail();
    }


}


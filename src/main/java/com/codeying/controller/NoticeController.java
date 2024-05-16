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
 * 公告控制器
 * 关于公告的增删改查操作都在这
 */
@Controller
@RequestMapping("notice")
public class NoticeController extends BaseController {

    //公告列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Notice> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的公告
        List<Notice> noticeList = pageInfo.getRecords();

                                
        //将数据放入request
                                StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Notice stAv : noticeList){
        }

        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("noticeList",noticeList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/notice-list";
    }

    private IPage<Notice> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Notice> paramMap = new QueryWrapper<>();
                            String title = req.getParameter("title");
            if(title !=null && !title .equals("")){
                            paramMap.like("title","%"+title+"%");
                    }
                                    String type = req.getParameter("type");
            if(type !=null && !type .equals("")){
                             paramMap.eq("type",type);
                    }
                                        if(req.getParameter("createtimeL")!=null && !req.getParameter("createtimeL").equals("")){
                Date createtimeL = DateUtil.strToDate(req.getParameter("createtimeL"));
                paramMap.ge("createtime",createtimeL);
            }
            if(req.getParameter("createtimeR")!=null && !req.getParameter("createtimeR").equals("")){
                Date createtimeR = DateUtil.strToDate(req.getParameter("createtimeR"));
                paramMap.le("createtime",createtimeR);
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
        IPage<Notice> pageInfo = new Page<Notice>().setCurrent(current).setSize(size);
        pageInfo = noticeService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //公告编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Notice entity = noticeService.getById(id);
                                                                                                                                        if(entity==null){
            entity = new Notice();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/notice-edit";
    }

    //公告详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Notice entity = noticeService.getById(id);
                                model.addAttribute("item", entity);
        return "/pages/notice-detail";
    }

    //公告保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Notice entityTemp ,MultipartFile filesFile ) {
        //上传附件到本地。
        if(filesFile !=null && filesFile.getSize() > 0){
            entityTemp.setFiles(CommonUtils.upload(filesFile));
        }
                String id = entityTemp.getId(); //主键
                    String title = entityTemp.getTitle(); //标题
                    String type = entityTemp.getType(); //类型
                    String content = entityTemp.getContent(); //内容
                    Date createtime = entityTemp.getCreatetime(); //发布时间
                    String files = entityTemp.getFiles(); //附件
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                    createtime = new Date();
                    entityTemp.setCreatetime (createtime);
                                                                                                                                    //唯一字段，则在此校验
                    QueryWrapper<Notice> wrappertitle = new QueryWrapper();
                    wrappertitle.eq("title",entityTemp.getTitle());
                    if( noticeService.list(wrappertitle).size() > 0){
                        return fail("标题 已存在！");
                    }
                                                                                                                                                        //=========添加之前
    
            //=========添加之前
            res = noticeService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = noticeService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //公告删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Notice delTemp = noticeService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = noticeService.removeById(id);
        return res ? success() : fail();
    }


}


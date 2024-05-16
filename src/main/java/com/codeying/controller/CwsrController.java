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
 * 财务收入控制器
 * 关于财务收入的增删改查操作都在这
 */
@Controller
@RequestMapping("cwsr")
public class CwsrController extends BaseController {

    //财务收入列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Cwsr> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的财务收入
        List<Cwsr> cwsrList = pageInfo.getRecords();

                    //定义需要统计的字段
                double sumprice = 0;
                        
        //将数据放入request
                                StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Cwsr stAv : cwsrList){
            if(stAv.getPrice ()!=null)
            sumprice += stAv.getPrice ();
        }

        statisticInfo.append("收入金额求和：").append(sumprice).append("; ");
        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("cwsrList",cwsrList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/cwsr-list";
    }

    private IPage<Cwsr> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Cwsr> paramMap = new QueryWrapper<>();
                            String title = req.getParameter("title");
            if(title !=null && !title .equals("")){
                            paramMap.like("title","%"+title+"%");
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
        IPage<Cwsr> pageInfo = new Page<Cwsr>().setCurrent(current).setSize(size);
        pageInfo = cwsrService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //财务收入编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Cwsr entity = cwsrService.getById(id);
                                                                                                                                        if(entity==null){
            entity = new Cwsr();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/cwsr-edit";
    }

    //财务收入详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Cwsr entity = cwsrService.getById(id);
                                model.addAttribute("item", entity);
        return "/pages/cwsr-detail";
    }

    //财务收入保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Cwsr entityTemp ,MultipartFile filesFile ) {
        //上传附件到本地。
        if(filesFile !=null && filesFile.getSize() > 0){
            entityTemp.setFiles(CommonUtils.upload(filesFile));
        }
                String id = entityTemp.getId(); //主键
                    String title = entityTemp.getTitle(); //收入标题
                    Double price = entityTemp.getPrice();//收入金额
                    String describtion = entityTemp.getDescribtion(); //收入说明
                    String files = entityTemp.getFiles(); //附件
                    Date createtime = entityTemp.getCreatetime(); //收入时间
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                                                                                                                                                                                                        //=========添加之前
    
            //=========添加之前
            res = cwsrService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = cwsrService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //财务收入删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Cwsr delTemp = cwsrService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = cwsrService.removeById(id);
        return res ? success() : fail();
    }


}


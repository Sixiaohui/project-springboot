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
 * 投诉建议控制器
 * 关于投诉建议的增删改查操作都在这
 */
@Controller
@RequestMapping("tousu")
public class TousuController extends BaseController {

    //投诉建议列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Tousu> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的投诉建议
        List<Tousu> tousuList = pageInfo.getRecords();

                            
        //将数据放入request
                List<User> useirdFrnList = userService.list(new QueryWrapper<User>()  );
        model.addAttribute("useirdFrnList",useirdFrnList );
                        StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Tousu stAv : tousuList){
            //获取外键数据:村民
            stAv .setUseirdFrn ( userService.getById(stAv .getUseird () ) );
        }

        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("tousuList",tousuList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/tousu-list";
    }

    private IPage<Tousu> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Tousu> paramMap = new QueryWrapper<>();
                            String useird = req.getParameter("useird");
            if(useird !=null && !useird .equals("")){
                             paramMap.eq("useird",useird);
                    }
                                //User TODO 只能查看 和自己相关的信息！
        if(req.getSession().getAttribute("role").equals("user")){
            paramMap.eq("useird",((User)req.getSession().getAttribute("user")).getId());//只能查看和自己相关的内容
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
        IPage<Tousu> pageInfo = new Page<Tousu>().setCurrent(current).setSize(size);
        pageInfo = tousuService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //投诉建议编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Tousu entity = tousuService.getById(id);
                                                        //获取外键数据，填充到下拉框 :村民
                                List<User> useirdFrnList = userService.list(new QueryWrapper<User>()  );
                model.addAttribute("useirdFrnList",useirdFrnList );
                                                                                        if(entity==null){
            entity = new Tousu();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/tousu-edit";
    }

    //投诉建议详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Tousu entity = tousuService.getById(id);
                //获取外键数据：村民
        entity.setUseirdFrn(userService.getById(entity.getUseird()));
                        model.addAttribute("item", entity);
        return "/pages/tousu-detail";
    }

    //投诉建议保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Tousu entityTemp ) {
                String id = entityTemp.getId(); //主键
                    String useird = entityTemp.getUseird(); //投诉人
                    String jianjie = entityTemp.getJianjie(); //投诉内容
                    Date createtime = entityTemp.getCreatetime(); //投诉时间
                    String huifu = entityTemp.getHuifu(); //回复
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                        createtime = new Date();
                    entityTemp.setCreatetime (createtime);
                                                                huifu = "";
                    entityTemp.setHuifu (huifu);
                                                                                                                                                                                                //=========添加之前
    
            //=========添加之前
            res = tousuService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = tousuService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //投诉建议删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Tousu delTemp = tousuService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = tousuService.removeById(id);
        return res ? success() : fail();
    }


}


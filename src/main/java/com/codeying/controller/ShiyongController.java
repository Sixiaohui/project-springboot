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
 * 村土地使用控制器
 * 关于村土地使用的增删改查操作都在这
 */
@Controller
@RequestMapping("shiyong")
public class ShiyongController extends BaseController {

    //村土地使用列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Shiyong> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的村土地使用
        List<Shiyong> shiyongList = pageInfo.getRecords();

                                
        //将数据放入request
                List<Wangge> wgidFrnList = wanggeService.list(new QueryWrapper<Wangge>()  .eq(role().equals("ganbu"),"fuzeid",getCurrentUser().getId())  );
        model.addAttribute("wgidFrnList",wgidFrnList );
                            StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Shiyong stAv : shiyongList){
            //获取外键数据:网格
            stAv .setWgidFrn ( wanggeService.getById(stAv .getWgid () ) );
        }

        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("shiyongList",shiyongList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/shiyong-list";
    }

    private IPage<Shiyong> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Shiyong> paramMap = new QueryWrapper<>();
                            String wgid = req.getParameter("wgid");
            if(wgid !=null && !wgid .equals("")){
                             paramMap.eq("wgid",wgid);
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
        IPage<Shiyong> pageInfo = new Page<Shiyong>().setCurrent(current).setSize(size);
        pageInfo = shiyongService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //村土地使用编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Shiyong entity = shiyongService.getById(id);
                                                        //获取外键数据，填充到下拉框 :网格
                                List<Wangge> wgidFrnList = wanggeService.list(new QueryWrapper<Wangge>()  .eq(role().equals("ganbu"),"fuzeid",getCurrentUser().getId())  );
                model.addAttribute("wgidFrnList",wgidFrnList );
                                                                                                            if(entity==null){
            entity = new Shiyong();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/shiyong-edit";
    }

    //村土地使用详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Shiyong entity = shiyongService.getById(id);
                //获取外键数据：网格
        entity.setWgidFrn(wanggeService.getById(entity.getWgid()));
                            model.addAttribute("item", entity);
        return "/pages/shiyong-detail";
    }

    //村土地使用保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Shiyong entityTemp ) {
                String id = entityTemp.getId(); //主键
                    String wgid = entityTemp.getWgid(); //所属网格
                    String place = entityTemp.getPlace(); //使用土地位置
                    String reason = entityTemp.getReason(); //使用原因
                    String type = entityTemp.getType(); //使用类型
                    Date createtime = entityTemp.getCreatetime(); //创建时间
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                createtime = new Date();
                    entityTemp.setCreatetime (createtime);
                                                                                                                                                                                                                            //=========添加之前
    
            //=========添加之前
            res = shiyongService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = shiyongService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //村土地使用删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Shiyong delTemp = shiyongService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = shiyongService.removeById(id);
        return res ? success() : fail();
    }


}


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
 * 网格控制器
 * 关于网格的增删改查操作都在这
 */
@Controller
@RequestMapping("wangge")
public class WanggeController extends BaseController {

    //网格列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Wangge> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的网格
        List<Wangge> wanggeList = pageInfo.getRecords();

                                //定义需要统计的字段
                double sumliyong = 0;
            
        //将数据放入request
                            List<Ganbu> fuzeidFrnList = ganbuService.list(new QueryWrapper<Ganbu>()  );
        model.addAttribute("fuzeidFrnList",fuzeidFrnList );
                StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Wangge stAv : wanggeList){
            //获取外键数据:村干部
            stAv .setFuzeidFrn ( ganbuService.getById(stAv .getFuzeid () ) );
            if(stAv.getLiyong ()!=null)
            sumliyong += stAv.getLiyong ();
        }

        if( wanggeList .size() > 0){
            statisticInfo.append("土地利用率平均：").append(String.format("%.2f",sumliyong / wanggeList .size())).append("; ");
        }
        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("wanggeList",wanggeList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/wangge-list";
    }

    private IPage<Wangge> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Wangge> paramMap = new QueryWrapper<>();
                            String name = req.getParameter("name");
            if(name !=null && !name .equals("")){
                            paramMap.like("name","%"+name+"%");
                    }
                                            String fuzeid = req.getParameter("fuzeid");
            if(fuzeid !=null && !fuzeid .equals("")){
                             paramMap.eq("fuzeid",fuzeid);
                    }
                        //Ganbu TODO 只能查看 和自己相关的信息！
        if(req.getSession().getAttribute("role").equals("ganbu")){
            paramMap.eq("fuzeid",((Ganbu)req.getSession().getAttribute("user")).getId());//只能查看和自己相关的内容
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
        IPage<Wangge> pageInfo = new Page<Wangge>().setCurrent(current).setSize(size);
        pageInfo = wanggeService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //网格编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Wangge entity = wanggeService.getById(id);
                                                                                                                    //获取外键数据，填充到下拉框 :村干部
                                List<Ganbu> fuzeidFrnList = ganbuService.list(new QueryWrapper<Ganbu>()  );
                model.addAttribute("fuzeidFrnList",fuzeidFrnList );
                                                if(entity==null){
            entity = new Wangge();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/wangge-edit";
    }

    //网格详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Wangge entity = wanggeService.getById(id);
                            //获取外键数据：村干部
        entity.setFuzeidFrn(ganbuService.getById(entity.getFuzeid()));
                model.addAttribute("item", entity);
        return "/pages/wangge-detail";
    }

    //网格保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Wangge entityTemp ) {
                String id = entityTemp.getId(); //主键
                    String name = entityTemp.getName(); //网格名
                    String numb = entityTemp.getNumb(); //网格编号
                    String quyu = entityTemp.getQuyu(); //所属区域
                    String fuzeid = entityTemp.getFuzeid(); //负责人
                    Double liyong = entityTemp.getLiyong();//土地利用率
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                                                                                    //唯一字段，则在此校验
                    QueryWrapper<Wangge> wrappername = new QueryWrapper();
                    wrappername.eq("name",entityTemp.getName());
                    if( wanggeService.list(wrappername).size() > 0){
                        return fail("网格名 已存在！");
                    }
                                                                //唯一字段，则在此校验
                    QueryWrapper<Wangge> wrappernumb = new QueryWrapper();
                    wrappernumb.eq("numb",entityTemp.getNumb());
                    if( wanggeService.list(wrappernumb).size() > 0){
                        return fail("网格编号 已存在！");
                    }
                                                                                                                            //=========添加之前
    
            //=========添加之前
            res = wanggeService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = wanggeService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //网格删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Wangge delTemp = wanggeService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = wanggeService.removeById(id);
        return res ? success() : fail();
    }


}


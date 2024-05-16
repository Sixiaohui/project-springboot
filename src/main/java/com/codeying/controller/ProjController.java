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
 * 村务项目控制器
 * 关于村务项目的增删改查操作都在这
 */
@Controller
@RequestMapping("proj")
public class ProjController extends BaseController {

    @ResponseBody
    @RequestMapping("kais")
    public ApiResult kais(String id){
        Proj byId = projService.getById(id);
        byId.setKais(new Date());
        projService.updateById(byId);
        return success();
    }
    @ResponseBody
    @RequestMapping("jies")
    public ApiResult jies(String id){
        Proj byId = projService.getById(id);
        byId.setJies(new Date());
        projService.updateById(byId);
        return success();
    }

    //村务项目列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Proj> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的村务项目
        List<Proj> projList = pageInfo.getRecords();

                                                
        //将数据放入request
                List<User> cunidFrnList = userService.list(new QueryWrapper<User>()  );
        model.addAttribute("cunidFrnList",cunidFrnList );
                                            StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Proj stAv : projList){
            //获取外键数据:村民
            stAv .setCunidFrn ( userService.getById(stAv .getCunid () ) );
        }

        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("projList",projList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/proj-list";
    }

    private IPage<Proj> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Proj> paramMap = new QueryWrapper<>();
                            String cunid = req.getParameter("cunid");
            if(cunid !=null && !cunid .equals("")){
                             paramMap.eq("cunid",cunid);
                    }
                                    String name = req.getParameter("name");
            if(name !=null && !name .equals("")){
                            paramMap.like("name","%"+name+"%");
                    }
                                                    String status = req.getParameter("status");
            if(status !=null && !status .equals("")){
                             paramMap.eq("status",status);
                    }
                            //User TODO 只能查看 和自己相关的信息！
        if(req.getSession().getAttribute("role").equals("user")){
            paramMap.eq("cunid",((User)req.getSession().getAttribute("user")).getId());//只能查看和自己相关的内容
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
        IPage<Proj> pageInfo = new Page<Proj>().setCurrent(current).setSize(size);
        pageInfo = projService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //村务项目编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Proj entity = projService.getById(id);
                                                        //获取外键数据，填充到下拉框 :村民
                                List<User> cunidFrnList = userService.list(new QueryWrapper<User>()  );
                model.addAttribute("cunidFrnList",cunidFrnList );
                                                                                                                                                                                            if(entity==null){
            entity = new Proj();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/proj-edit";
    }

    //村务项目详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Proj entity = projService.getById(id);
                //获取外键数据：村民
        entity.setCunidFrn(userService.getById(entity.getCunid()));
                                            model.addAttribute("item", entity);
        return "/pages/proj-detail";
    }

    //村务项目保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Proj entityTemp ) {
                String id = entityTemp.getId(); //主键
                    String cunid = entityTemp.getCunid(); //申报村民
                    String name = entityTemp.getName(); //项目名
                    String lixiang = entityTemp.getLixiang(); //项目立项
                    String jinzhan = entityTemp.getJinzhan(); //项目进展
                    String remark = entityTemp.getRemark(); //项目备注
                    Double jingfei = entityTemp.getJingfei();//项目经费
                    String status = entityTemp.getStatus(); //审核状态
                    Date kais = entityTemp.getKais(); //开始时间
                    Date jies = entityTemp.getJies(); //结束时间
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                                                                        status = "待审核";
                    entityTemp.setStatus (status);
                                                                kais = null;
                    entityTemp.setKais (kais);
                                                                jies = null;
                    entityTemp.setJies (jies);
                                                                                                                                    //唯一字段，则在此校验
                    QueryWrapper<Proj> wrappername = new QueryWrapper();
                    wrappername.eq("name",entityTemp.getName());
                    if( projService.list(wrappername).size() > 0){
                        return fail("项目名 已存在！");
                    }
                                                                                                                                                                                                                                            //=========添加之前
    
            //=========添加之前
            res = projService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = projService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //村务项目删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Proj delTemp = projService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = projService.removeById(id);
        return res ? success() : fail();
    }


}


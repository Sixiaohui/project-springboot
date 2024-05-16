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
 * 经济收入控制器
 * 关于经济收入的增删改查操作都在这
 */
@Controller
@RequestMapping("shouru")
public class ShouruController extends BaseController {

    //经济收入列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Shouru> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的经济收入
        List<Shouru> shouruList = pageInfo.getRecords();

                        //定义需要统计的字段
                double sumshouru = 0;
                
        //将数据放入request
                List<User> cunmidFrnList = userService.list(new QueryWrapper<User>()  );
        model.addAttribute("cunmidFrnList",cunmidFrnList );
                        StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Shouru stAv : shouruList){
            //获取外键数据:村民
            stAv .setCunmidFrn ( userService.getById(stAv .getCunmid () ) );
            if(stAv.getShouru ()!=null)
            sumshouru += stAv.getShouru ();
        }

        statisticInfo.append("收入求和：").append(sumshouru).append("; ");
        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("shouruList",shouruList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/shouru-list";
    }

    private IPage<Shouru> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Shouru> paramMap = new QueryWrapper<>();
                            String cunmid = req.getParameter("cunmid");
            if(cunmid !=null && !cunmid .equals("")){
                             paramMap.eq("cunmid",cunmid);
                    }
                                    String year = req.getParameter("year");
            if(year !=null && !year .equals("")){
                            paramMap.like("year","%"+year+"%");
                    }
                                    if(req.getParameter("shouruL")!=null && !req.getParameter("shouruL").equals("")){
                Double shouruL = Double.valueOf(req.getParameter("shouruL"));
                paramMap.ge("shouru",shouruL);
            }
            if(req.getParameter("shouruR")!=null && !req.getParameter("shouruR").equals("")){
                Double shouruR = Double.valueOf(req.getParameter("shouruR"));
                paramMap.le("shouru",shouruR);
            }
                        //User TODO 只能查看 和自己相关的信息！
        if(req.getSession().getAttribute("role").equals("user")){
            paramMap.eq("cunmid",((User)req.getSession().getAttribute("user")).getId());//只能查看和自己相关的内容
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
        IPage<Shouru> pageInfo = new Page<Shouru>().setCurrent(current).setSize(size);
        pageInfo = shouruService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //经济收入编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Shouru entity = shouruService.getById(id);
                                                        //获取外键数据，填充到下拉框 :村民
                                List<User> cunmidFrnList = userService.list(new QueryWrapper<User>()  );
                model.addAttribute("cunmidFrnList",cunmidFrnList );
                                                                                        if(entity==null){
            entity = new Shouru();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/shouru-edit";
    }

    //经济收入详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Shouru entity = shouruService.getById(id);
                //获取外键数据：村民
        entity.setCunmidFrn(userService.getById(entity.getCunmid()));
                        model.addAttribute("item", entity);
        return "/pages/shouru-detail";
    }

    //经济收入保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Shouru entityTemp ) {
                String id = entityTemp.getId(); //主键
                    String cunmid = entityTemp.getCunmid(); //村民
                    String year = entityTemp.getYear(); //年份
                    Double shouru = entityTemp.getShouru();//收入
                    String remark = entityTemp.getRemark(); //备注
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                                                                                                                                                //=========添加之前
    
            //=========添加之前
            res = shouruService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = shouruService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //经济收入删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Shouru delTemp = shouruService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = shouruService.removeById(id);
        return res ? success() : fail();
    }


}

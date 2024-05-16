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
 * 资金使用控制器
 * 关于资金使用的增删改查操作都在这
 */
@Controller
@RequestMapping("zjsy")
public class ZjsyController extends BaseController {

    //资金使用列表页
    @RequestMapping("list")
    public String list(Model model,Integer pageIndex,String []orderby){
        //获取列表数据
        IPage<Zjsy> pageInfo = pageInfo(pageIndex, 15,orderby);//分页大小
        //获取到的资金使用
        List<Zjsy> zjsyList = pageInfo.getRecords();

                        //定义需要统计的字段
                double sumprice = 0;
                            
        //将数据放入request
                                    List<Ganbu> nameFrnList = ganbuService.list(new QueryWrapper<Ganbu>()  );
        model.addAttribute("nameFrnList",nameFrnList );
                StringBuilder statisticInfo = new StringBuilder();
        //循环遍历list数据，统计、获取外键数据
        for(Zjsy stAv : zjsyList){
            if(stAv.getPrice ()!=null)
            sumprice += stAv.getPrice ();
            //获取外键数据:村干部
            stAv .setNameFrn ( ganbuService.getById(stAv .getName () ) );
        }

        statisticInfo.append("支出金额求和：").append(sumprice).append("; ");
        model.addAttribute("statisticInfo", statisticInfo.toString());
        model.addAttribute("zjsyList",zjsyList);
        //将分页信息传回前端
        PagerVO pager = new PagerVO((int) pageInfo.getCurrent(), (int) pageInfo.getSize(), (int) pageInfo.getTotal());
        model.addAttribute("pager",pager);
        return "/pages/zjsy-list";
    }

    private IPage<Zjsy> pageInfo(Integer current,long size,String []orderby){
        if(current == null){
            current = 1;//默认访问第一页（分页）
        }
        //用于存储查询的条件
        QueryWrapper<Zjsy> paramMap = new QueryWrapper<>();
                            String yongtu = req.getParameter("yongtu");
            if(yongtu !=null && !yongtu .equals("")){
                            paramMap.like("yongtu","%"+yongtu+"%");
                    }
                                    String type = req.getParameter("type");
            if(type !=null && !type .equals("")){
                            paramMap.like("type","%"+type+"%");
                    }
                                        if(req.getParameter("shijianL")!=null && !req.getParameter("shijianL").equals("")){
                Date shijianL = DateUtil.strToDate(req.getParameter("shijianL"));
                paramMap.ge("shijian",shijianL);
            }
            if(req.getParameter("shijianR")!=null && !req.getParameter("shijianR").equals("")){
                Date shijianR = DateUtil.strToDate(req.getParameter("shijianR"));
                paramMap.le("shijian",shijianR);
            }
                                        String name = req.getParameter("name");
            if(name !=null && !name .equals("")){
                             paramMap.eq("name",name);
                    }
                        //Ganbu TODO 只能查看 和自己相关的信息！
        if(req.getSession().getAttribute("role").equals("ganbu")){
            paramMap.eq("name",((Ganbu)req.getSession().getAttribute("user")).getId());//只能查看和自己相关的内容
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
        IPage<Zjsy> pageInfo = new Page<Zjsy>().setCurrent(current).setSize(size);
        pageInfo = zjsyService.page(pageInfo,paramMap);
        return pageInfo;
    }

    //资金使用编辑页
    @RequestMapping("edit")
    public String edit(String id,Model model){
        //根据id获取到记录
        Zjsy entity = zjsyService.getById(id);
                                                                                                                                                            //获取外键数据，填充到下拉框 :村干部
                                List<Ganbu> nameFrnList = ganbuService.list(new QueryWrapper<Ganbu>()  );
                model.addAttribute("nameFrnList",nameFrnList );
                                                if(entity==null){
            entity = new Zjsy();
            //TODO 可接受其他参数,给前端
        }
        model.addAttribute("item",entity);
        return "/pages/zjsy-edit";
    }

    //资金使用详情页
    @RequestMapping("detail")
    public String detail(String id,Model model){
        Zjsy entity = zjsyService.getById(id);
                                    //获取外键数据：村干部
        entity.setNameFrn(ganbuService.getById(entity.getName()));
                model.addAttribute("item", entity);
        return "/pages/zjsy-detail";
    }

    //资金使用保存
    @RequestMapping("save")
    @ResponseBody
    public ApiResult save(Zjsy entityTemp ,MultipartFile filesFile ) {
        //上传附件到本地。
        if(filesFile !=null && filesFile.getSize() > 0){
            entityTemp.setFiles(CommonUtils.upload(filesFile));
        }
                String id = entityTemp.getId(); //主键
                    String yongtu = entityTemp.getYongtu(); //支出用途
                    String type = entityTemp.getType(); //支出类型
                    Double price = entityTemp.getPrice();//支出金额
                    Date shijian = entityTemp.getShijian(); //支出时间
                    String mingxi = entityTemp.getMingxi(); //使用明细
                    String name = entityTemp.getName(); //负责人
                    String files = entityTemp.getFiles(); //附件
            
        //新增或更新
        boolean res = false;
        if(entityTemp.getId() == null || "".equals(entityTemp.getId())){//新增
                                                id = CommonUtils.newId();
                    entityTemp.setId (id);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        //=========添加之前
    
            //=========添加之前
            res = zjsyService.save(entityTemp);
        }else {
            //=========修改之前
    
            //=========修改之前
            res = zjsyService.updateById(entityTemp);
        }
        return res ? ApiResult.successMsg("保存成功") : ApiResult.fail("保存失败");//标记保存成功
    }

    //资金使用删除
    @RequestMapping("delete")
    @ResponseBody
    public ApiResult delete(String id){
        Zjsy delTemp = zjsyService.getById(id);
//=========删除之前
    
//=========删除之前
        //根据ID删除记录
        boolean res = zjsyService.removeById(id);
        return res ? success() : fail();
    }


}

